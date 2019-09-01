package io.github.mat3e.todos.anytimetask;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface AnytimeRepository extends JpaRepository<AnytimeTask, Integer> {
}
