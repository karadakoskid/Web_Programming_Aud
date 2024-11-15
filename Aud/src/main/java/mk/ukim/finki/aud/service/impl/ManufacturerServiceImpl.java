package mk.ukim.finki.aud.service.impl;

import mk.ukim.finki.aud.model.Manufacturer;
import mk.ukim.finki.aud.repository.InMemoryManufacturerRepository;
import mk.ukim.finki.aud.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    private final InMemoryManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(InMemoryManufacturerRepository manufacturerRepository) {
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

    @Override
    public Optional<Manufacturer> save(String name, String address) {
        return this.manufacturerRepository.save(name,address);
    }

    @Override
    public boolean deleteById(Long id) {
        return this.manufacturerRepository.deleteById(id);
    }
}
