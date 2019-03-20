package com.grapeup.lab.chatapp.repositories;

import com.grapeup.lab.chatapp.entities.Message;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface MessageRepository extends ElasticsearchRepository<Message, String> {
}
