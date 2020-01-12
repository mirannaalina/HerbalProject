package ro.herb.herbalproject.service.data;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.herb.herbalproject.persistence.data.DataEntity;
import ro.herb.herbalproject.persistence.data.DataRepository;

import java.util.List;

@Service
public class DataService {

    private final DataRepository dataRepository;

    @Autowired
    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Transactional
    public void save(String date, int kg, int bodyfat) {

        DataEntity dataEntity = new DataEntity();
        dataEntity.setDate(date);
        dataEntity.setKg(kg);
        dataEntity.setBodyfat(bodyfat);
        dataRepository.save(dataEntity);
    }

    @Transactional(readOnly = true)
    public List<DataEntity>  findAll() {

        return dataRepository.findAll();
    }


}
