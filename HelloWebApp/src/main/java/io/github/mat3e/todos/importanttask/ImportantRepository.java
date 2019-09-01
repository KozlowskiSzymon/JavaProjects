package io.github.mat3e.todos.importanttask;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ImportantRepository extends JpaRepository<ImportantTask, Integer> {
}
