package es.pcb.pcbgrupo16.Controller;

import es.pcb.pcbgrupo16.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class Producto {

//    @Autowired
//    private ProductoService productoService;
//
//
//    @GetMapping
//    public List<AtributoUsuario> listarProductos(){
//        return atributoService.allAtributos();
//    }
//
//    @GetMapping("/{id}")
//    public AtributoUsuario getAtributo(@PathVariable float id){
//        return atributoService.getAtributo(id);
//        //TODO controloar fallos
//    }
//
//    @PostMapping("/crearatr")
//    public AtributoUsuario crearAtributo(@RequestBody AtributoUsuario atr){
//        return atributoService.createAtribute(atr);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteAtributo(@PathVariable float id){
//        return atributoService.deleteAtributo(id);
//        // TODO controlar errores
//
//    }
//
//    @PutMapping("/{id}")
//    public AtributoUsuario updateAtributo(@PathVariable float id, @RequestBody AtributoUsuario cosasnuevas ){
//        AtributoUsuario atributo = atributoService.getAtributo(id);
//
//        atributo.setNombre(cosasnuevas.getNombre());
//        atributo.setTipo(cosasnuevas.getTipo());
//        return atributoService.createAtribute(atributo);
//    }
}
