package com.tts.TechTalentTwitter.repository;

@Repository
public interface EndUserRepository extends CrudRepository<User, Long> {
User findByUsername(String username);
}
