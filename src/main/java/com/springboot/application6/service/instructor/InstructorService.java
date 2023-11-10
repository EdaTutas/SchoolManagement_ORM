package com.springboot.application6.service.instructor;

import com.springboot.application6.model.Instructor;
import com.springboot.application6.model.InstructorDetail;
import com.springboot.application6.repository.InstructorRepository;
import com.springboot.application6.service.common.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService extends CommonServiceImpl<Instructor> {

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        super(instructorRepository);
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructor> getAll() {
        return super.getAll();
    }

    @Override
    public Instructor getById(Long id) {
        return super.getById(id);
    }

    @Override
    public Instructor save(Instructor instructor) {
        return super.save(instructor);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }

    /*
    @Override
    public void update(Instructor instructor) {
        super.update(instructor);
    }



     */
    @Override
    public void update(Instructor updatedInstructor) {
        Long instructorId = updatedInstructor.getId();

        // Veritabanından mevcut instructor'ı al
        Instructor existingInstructor = getById(instructorId);

        // Güncelleme işlemlerini gerçekleştir
        existingInstructor.setFirstName(updatedInstructor.getFirstName());
        existingInstructor.setLastName(updatedInstructor.getLastName());
        existingInstructor.setEmail(updatedInstructor.getEmail());

        // Instructor'ın InstructorDetail'ını güncelle
        InstructorDetail existingDetail = existingInstructor.getInstructorDetail();
        InstructorDetail updatedDetail = updatedInstructor.getInstructorDetail();

        if (existingDetail != null && updatedDetail != null) {
            // Güncelleme işlemlerini gerçekleştir
            existingDetail.setAdress(updatedDetail.getAdress());
            existingDetail.setHobby(updatedDetail.getHobby());
        }

        // Güncellenmiş Instructor'ı kaydet
        instructorRepository.save(existingInstructor);
    }




    @Override
    protected Long getEntityId(Instructor entity) {
        return  entity.getId();
    }
}