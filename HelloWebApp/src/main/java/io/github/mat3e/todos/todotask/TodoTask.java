package io.github.mat3e.todos.todotask;


import io.github.mat3e.todos.Todo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "todotasks")
class TodoTask extends Todo {
}
