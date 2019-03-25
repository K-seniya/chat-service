package com.grapeup.lab.chatapp.repositories;

import com.grapeup.lab.chatapp.entities.Message;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MessageRepository extends ElasticsearchRepository<Message, String> {
    @Query("{\"bool\" : {\"must\" : {\"field\" : {\"room\" : \"?0\"}}}}")
    Iterable<Message> findByRoom(String room);

    @Query(value= "{\"bool\" : {\"must\" : {\"field\" : {\"room\" : \"?0\"}}}}", delete = true)
    Long deleteByRoom(String room);
}
