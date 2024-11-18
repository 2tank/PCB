package com.example.pcb.controlador;

import com.example.pcb.Service.ProductoService;
import com.example.pcb.entidades.Imagen;
import com.example.pcb.entidades.Producto;
import com.example.pcb.repositorios.ImagenRepository;
import com.example.pcb.repositorios.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoControler {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> listarProductos(){
        return productoService.allProductos();
    }

    @GetMapping("/{id}")
    public Producto getProducto(@PathVariable int id){
        try{
            Producto p = productoService.getProducto(id);
            return p;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/crearProducto")
    public Producto crearProducto(@RequestBody Producto producto){
        return productoService.crearProducto(producto);
    }

    @DeleteMapping("/{id}")
    public void borrarProducto(@PathVariable int id){
        return productoService.borrarProducto(id);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable int id, @RequestBody Producto cosas_nuevas){
        Producto producto = productoService.getProducto(id);

        producto.setThumbmail(cosas_nuevas.getThumbmail());
        producto.setNombre(cosas_nuevas.getNombre());
        producto.setFechaModificacion(new Date());

        return productoService.crearProducto(producto);
    }

}
