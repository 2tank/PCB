package com.example.pcb.controlador;

import com.example.pcb.entidades.Imagen;
import com.example.pcb.repositorios.ImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/images/")
public class ImagenController {

    @Autowired
    private ImagenRepository imagenRepository;


    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable int id) {
        Optional<Imagen> imagenOptional = imagenRepository.findById(id);

        if (imagenOptional.isPresent()) {
            Imagen imagen = imagenOptional.get();
            byte[] imageBytes = imagen.getImageImagen();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG); // Ajusta el tipo de contenido según tu imagen
            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
