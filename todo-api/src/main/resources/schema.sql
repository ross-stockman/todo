-- Create TodoList table
CREATE TABLE todo (
    id VARCHAR(36) PRIMARY KEY, -- Primary key with random UUID
    version INT DEFAULT 1 NOT NULL, -- version for optimistic locking
    title VARCHAR(255) NOT NULL, -- Title of the TODO list
    description VARCHAR(1024) -- Description of the TODO list
);

-- Create TodoTask table
CREATE TABLE task (
    id VARCHAR(36) PRIMARY KEY, -- Primary key with random UUID
    version INT DEFAULT 1 NOT NULL, -- version for optimistic locking
    title VARCHAR(255) NOT NULL, -- Title of the task
    completed BOOLEAN NOT NULL, -- Whether the task is completed
    notes VARCHAR(1024), -- Additional notes about the task
    assigned VARCHAR(255), -- Person assigned to this task
    due TIMESTAMP, -- Due date of the task
    todo_id VARCHAR(36) NOT NULL, -- Foreign key to the TodoList table
    CONSTRAINT fk_todo FOREIGN KEY (todo_id) REFERENCES todo(id) ON DELETE CASCADE
);

-- Create Comment table
CREATE TABLE comment (
    id VARCHAR(36) PRIMARY KEY, -- Primary key with random UUID
    version INT DEFAULT 1 NOT NULL, -- version for optimistic locking
    comment TEXT NOT NULL, -- The comment text
    posted_by VARCHAR(255) NOT NULL, -- Who posted the comment
    posted_at TIMESTAMP NOT NULL, -- When the comment was posted
    task_id VARCHAR(36) NOT NULL, -- Foreign key to the TodoTask table
    CONSTRAINT fk_task FOREIGN KEY (task_id) REFERENCES task(id) ON DELETE CASCADE
);