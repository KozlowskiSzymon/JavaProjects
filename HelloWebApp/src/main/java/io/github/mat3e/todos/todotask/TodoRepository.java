package io.github.mat3e.todos.todotask;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TodoRepository extends JpaRepository<TodoTask, Integer> {
}
