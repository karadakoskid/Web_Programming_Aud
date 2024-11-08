package mk.ukim.finki.aud.service.impl;

import mk.ukim.finki.aud.model.Manufacturer;
import mk.ukim.finki.aud.repository.InMemoryManufacturerRepository;
import mk.ukim.finki.aud.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerImpl implements ManufacturerService {
    private final InMemoryManufacturerRepository manufacturerRepository;

    public ManufacturerImpl(InMemoryManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> findAll() {
        return this.manufacturerRepository.findAll();
    }

    @Override
    public Optional<Manufacturer> findById(Long id) {
        return this.manufacturerRepository.findById(id);
    }
}