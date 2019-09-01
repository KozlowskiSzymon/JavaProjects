package io.github.mat3e.todos.importanttask;


import io.github.mat3e.todos.Todo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "importanttasks")
class ImportantTask extends Todo {
}
