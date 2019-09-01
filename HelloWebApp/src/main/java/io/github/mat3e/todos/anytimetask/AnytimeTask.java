package io.github.mat3e.todos.anytimetask;


import io.github.mat3e.todos.Todo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "anytimetasks")
class AnytimeTask extends Todo {
}
