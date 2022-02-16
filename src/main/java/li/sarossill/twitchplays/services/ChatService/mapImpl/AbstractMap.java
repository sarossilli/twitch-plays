package li.sarossill.twitchplays.services.ChatService.mapImpl;

import li.sarossill.twitchplays.model.BaseEntity;

import java.util.*;

public class AbstractMap<T extends BaseEntity, ID extends Long> {
    protected Map<Long,T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(T object){
        if(object != null){
            if(object.getId() == null){
                object.setId(getNextId());
            }
            map.put(object.getId(),object);
        }else{
            throw new RuntimeException("AbstractMap Object is null");
        }

        return object;
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    void deleteByID(ID id){
        map.remove(id);
    }

    private Long getNextId(){
        Long newId = null;
        try{
            newId = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e){
            newId = 1L;
        }
        return newId;
    }
}
