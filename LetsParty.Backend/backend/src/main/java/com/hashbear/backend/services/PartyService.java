package com.hashbear.backend.services;

import com.hashbear.backend.model.dtos.PartyDTO;
import com.hashbear.backend.model.mappers.PartyMapper;
import com.hashbear.backend.repositories.PartyRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class PartyService {
    @Autowired
    private final PartyRepository partyRepository;
    private final PartyMapper partyMapper = new PartyMapper();

    public PartyDTO createParty(PartyDTO party) {
        return partyMapper.partyToPartyDTO(partyRepository.save(partyMapper.partyDTOToParty(party)));
    }

    public PartyDTO getParty(UUID id) {
        if(!partyRepository.existsById(id))
            throw new RuntimeException("Party not found with id: " + id);
        return partyMapper.partyToPartyDTO(partyRepository.findById(id).get());
    }
<<<<<<< Updated upstream
=======
<<<<<<< Updated upstream
=======
>>>>>>> Stashed changes

    public PartyDTO[] getAllParties() {
        return partyRepository.findAll().stream().map(partyMapper::partyToPartyDTO).toArray(PartyDTO[]::new);
    }
<<<<<<< Updated upstream
=======

    public void deleteParty(UUID id) {
        if(!partyRepository.existsById(id))
            throw new RuntimeException("Party not found with id: " + id);
        partyRepository.deleteById(id);
    }
>>>>>>> Stashed changes
>>>>>>> Stashed changes
}
