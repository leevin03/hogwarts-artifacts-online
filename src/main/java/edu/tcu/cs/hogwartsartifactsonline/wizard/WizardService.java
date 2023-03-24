package edu.tcu.cs.hogwartsartifactsonline.wizard;

import edu.tcu.cs.hogwartsartifactsonline.artifact.ArtifactNotFoundException;
import edu.tcu.cs.hogwartsartifactsonline.artifact.utils.IdWorker;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class WizardService {
    private final WizardRepository wizardRepository;

    public WizardService(WizardRepository wizardRepository, IdWorker idWorker) {
        this.wizardRepository = wizardRepository;
    }

    public Wizard findById(Integer wizardId){
        return this.wizardRepository.findById(wizardId)
                .orElseThrow(() -> new WizardNotFoundException(wizardId));
    }

    public List<Wizard> findAll(){
        return this.wizardRepository.findAll();
    }

    public Wizard save(Wizard newWizard){
        //newWizard.setId((int) (wizardRepository.count() + 1));
        return this.wizardRepository.save(newWizard);
    }

    //only update wizard name
    public Wizard update(Integer wizardId, Wizard update) {
        return this.wizardRepository.findById(wizardId)
                .map(oldWizard -> {
                    oldWizard.setName(update.getName());
                    return this.wizardRepository.save(oldWizard);
                })
                .orElseThrow(() -> new WizardNotFoundException(wizardId));
    }

    public void delete(Integer wizardId) {
        Wizard wizardToBeDeleted = this.wizardRepository.findById(wizardId)
                .orElseThrow(() -> new WizardNotFoundException(wizardId));

        // unassign artifacts before wizard deletion
        wizardToBeDeleted.removeAllArtifacts();
        this.wizardRepository.deleteById(wizardId);
    }


}
