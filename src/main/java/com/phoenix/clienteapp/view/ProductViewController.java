package com.phoenix.clienteapp.view;

import com.phoenix.clienteapp.model.Product;
import com.phoenix.clienteapp.service.ProductService;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

@Named("productView")
@ViewScoped
public class ProductViewController implements Serializable {

    private List<Product> products;
    private Product selectedProduct;
    private List<Product> selectedProducts;

    @Inject
    private ProductService service;

    @PostConstruct
    public void init() {
        this.products = service.getProducts();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public List<Product> getSelectedProducts() {
        return selectedProducts;
    }

    public void setSelectedProducts(List<Product> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }

    public void setService(ProductService service) {
        this.service = service;
    }

    public void openNew() {
        this.selectedProduct = new Product();
    }

    public void saveProduct() {
        if (this.selectedProduct.getId() == 0) {
            //Salvar en el array
            //Obtener el ultimo id
            // products
            service.saveProduct(this.selectedProduct);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se agrego un producto"));
        } else {
            service.updateProduct(this.selectedProduct);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Se actualizo un producto"));
        }
        //Vuelve a leer los productos de la base de datos
        this.init();
        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
        PrimeFaces.current().ajax().update("form:messages", "form:data-products");
    }

    public void deleteProduct() {
        this.products.remove(this.selectedProduct);
        this.selectedProduct = null;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:data-products");
    }

    /**
     * Hace un borrado logico
     *
     */
    public void changeStateProduct() {
        service.changeStateProduct(this.selectedProduct.getId());
        this.init();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:data-products");
    }
}
