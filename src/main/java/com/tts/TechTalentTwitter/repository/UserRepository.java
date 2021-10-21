package com.tts.TechTalentTwitter.repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
User findByUsername(String username);
}
