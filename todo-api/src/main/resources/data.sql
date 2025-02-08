-- Insert into todo
INSERT INTO todo (id, version, title, description)
VALUES
    ('11111111-1111-1111-1111-111111111111', 1, 'Grocery Shopping', 'List of items to purchase for groceries.'),
    ('22222222-2222-2222-2222-222222222222', 1, 'Work Tasks', 'Pending tasks to complete at work.'),
    ('33333333-3333-3333-3333-333333333333', 1, 'Weekend Chores', 'Things to do over the weekend.'),
    ('44444444-4444-4444-4444-444444444444', 1, 'Do Homework', 'Quiz on Friday!');

-- Insert into TodoTask
INSERT INTO task (id, version, title, completed, notes, assigned, due, todo_id)
VALUES
    -- Tasks for Grocery Shopping
    ('aaaa-bbbb-cccc-dddd-111111111111', 1, 'Buy Milk', FALSE, 'Get low-fat milk.', 'John', '2023-11-10 10:00:00', '11111111-1111-1111-1111-111111111111'),
    ('aaaa-bbbb-cccc-dddd-111111111112', 1, 'Buy Bread', FALSE, 'Whole grain bread.', NULL, '2023-11-11 09:30:00', '11111111-1111-1111-1111-111111111111'),

    -- Tasks for Work Tasks
    ('bbbb-cccc-dddd-eeee-222222222222', 1, 'Send Report', TRUE, 'Submit the revenue report.', 'Alice', '2023-11-11 15:00:00', '22222222-2222-2222-2222-222222222222'),
    ('bbbb-cccc-dddd-eeee-222222222223', 1, 'Fix Bug', FALSE, 'Investigate and resolve ticket #1234.', 'Bob', '2023-11-12 16:00:00', '22222222-2222-2222-2222-222222222222'),

    -- Tasks for Weekend Chores
    ('cccc-dddd-eeee-ffff-333333333333', 1, 'Clean Garage', FALSE, 'Sort out old boxes.', 'John', '2023-11-13 10:00:00', '33333333-3333-3333-3333-333333333333'),
    ('cccc-dddd-eeee-ffff-333333333334', 1, 'Wash Car', FALSE, 'Take the car to the car wash.', NULL, '2023-11-14 14:00:00', '33333333-3333-3333-3333-333333333333');

-- Insert into Comment
INSERT INTO comment (id, version, comment, posted_by, posted_at, task_id)
VALUES
    -- Comments for 'Buy Milk'
    ('1a2b-3c4d-5e6f-7g8h-111111111111', 1, 'Don’t forget to check the expiry date!', 'Jane', '2023-11-10 08:45:00', 'aaaa-bbbb-cccc-dddd-111111111111'),
    ('1a2b-3c4d-5e6f-7g8h-111111111112', 1, 'Milk prices are high this week.', 'Mike', '2023-11-10 09:10:00', 'aaaa-bbbb-cccc-dddd-111111111111'),

    -- Comments for 'Send Report'
    ('2b3c-4d5e-6f7g-8h9i-222222222222', 1, 'Report was submitted on time.', 'Alice', '2023-11-11 16:30:00', 'bbbb-cccc-dddd-eeee-222222222222'),

    -- Comments for 'Fix Bug'
    ('2b3c-4d5e-6f7g-8h9i-222222222223', 1, 'Need more details to resolve the bug.', 'Bob', '2023-11-12 10:00:00', 'bbbb-cccc-dddd-eeee-222222222223'),

    -- Comments for 'Clean Garage'
    ('3c4d-5e6f-7g8h-9i0j-333333333333', 1, 'Don’t throw away the boxes without checking.', 'John', '2023-11-13 09:00:00', 'cccc-dddd-eeee-ffff-333333333333');

-- Insert the new TodoList
INSERT INTO todo (id, version, title, description)
VALUES
    ('55555555-5555-5555-5555-555555555555', 1, 'Big Project Tasks', 'A large project with many tasks for pagination testing.');

-- Insert 25 tasks for the new TodoList (Big Project Tasks)
INSERT INTO task (id, version, title, completed, notes, assigned, due, todo_id)
VALUES
    ('task0001-5555-5555-5555-555555555555', 1, 'Task 001', FALSE, 'Details for task 001.', 'Alice', '2023-11-15 08:00:00', '55555555-5555-5555-5555-555555555555'),
    ('task0002-5555-5555-5555-555555555555', 1, 'Task 002', FALSE, 'Details for task 002.', 'Alice', '2023-11-15 09:00:00', '55555555-5555-5555-5555-555555555555'),
    ('task0003-5555-5555-5555-555555555555', 1, 'Task 003', FALSE, 'Details for task 003.', 'Bob', '2023-11-15 10:00:00', '55555555-5555-5555-5555-555555555555'),
    ('task0004-5555-5555-5555-555555555555', 1, 'Task 004', TRUE, 'Details for task 004.', 'Bob', '2023-11-15 11:00:00', '55555555-5555-5555-5555-555555555555'),
    ('task0005-5555-5555-5555-555555555555', 1, 'Task 005', TRUE, 'Details for task 005.', 'Alice', '2023-11-15 12:00:00', '55555555-5555-5555-5555-555555555555'),
    ('task0006-5555-5555-5555-555555555555', 1, 'Task 006', FALSE, 'Details for task 006.', 'Chris', '2023-11-15 13:00:00', '55555555-5555-5555-5555-555555555555'),
    ('task0007-5555-5555-5555-555555555555', 1, 'Task 007', FALSE, 'Details for task 007.', 'Chris', '2023-11-15 14:00:00', '55555555-5555-5555-5555-555555555555'),
    ('task0008-5555-5555-5555-555555555555', 1, 'Task 008', TRUE, 'Details for task 008.', NULL, '2023-11-15 15:00:00', '55555555-5555-5555-5555-555555555555'),
    ('task0009-5555-5555-5555-555555555555', 1, 'Task 009', TRUE, 'Details for task 009.', NULL, '2023-11-15 16:00:00', '55555555-5555-5555-5555-555555555555'),
    ('task0010-5555-5555-5555-555555555555', 1, 'Task 010', FALSE, 'Details for task 010.', 'Bob', '2023-11-15 17:00:00', '55555555-5555-5555-5555-555555555555'),
    ('task0011-5555-5555-5555-555555555555', 1, 'Task 011', TRUE, 'Details for task 011.', 'Alice', '2023-11-16 08:00:00', '55555555-5555-5555-5555-555555555555'),
    ('task0012-5555-5555-5555-555555555555', 1, 'Task 012', FALSE, 'Details for task 012.', NULL, '2023-11-16 09:00:00', '55555555-5555-5555-5555-555555555555'),
    ('task0013-5555-5555-5555-555555555555', 1, 'Task 013', TRUE, 'Details for task 013.', 'Chris', '2023-11-16 10:00:00', '55555555-5555-5555-5555-555555555555'),
    ('task0014-5555-5555-5555-555555555555', 1, 'Task 014', FALSE, 'Details for task 014.', 'Chris', '2023-11-16 11:00:00', '55555555-5555-5555-5555-555555555555'),
    ('task0015-5555-5555-5555-555555555555', 1, 'Task 015', FALSE, 'Details for task 015.', 'Bob', '2023-11-16 12:00:00', '55555555-5555-5555-5555-555555555555'),
    ('task0016-5555-5555-5555-555555555555', 1, 'Task 016', TRUE, 'Details for task 016.', 'Alice', '2023-11-16 13:00:00', '55555555-5555-5555-5555-555555555555'),
    ('task0017-5555-5555-5555-555555555555', 1, 'Task 017', FALSE, 'Details for task 017.', 'Alice', '2023-11-16 14:00:00', '55555555-5555-5555-5555-555555555555'),
    ('task0018-5555-5555-5555-555555555555', 1, 'Task 018', TRUE, 'Details for task 018.', NULL, '2023-11-16 15:00:00', '55555555-5555-5555-5555-555555555555'),
    ('task0019-5555-5555-5555-555555555555', 1, 'Task 019', FALSE, 'Details for task 019.', 'Chris', '2023-11-16 16:00:00', '55555555-5555-5555-5555-555555555555'),
    ('task0020-5555-5555-5555-555555555555', 1, 'Task 020', TRUE, 'Details for task 020.', 'Chris', '2023-11-16 17:00:00', '55555555-5555-5555-5555-555555555555'),
    ('task0021-5555-5555-5555-555555555555', 1, 'Task 021', FALSE, 'Details for task 021.', 'Bob', '2023-11-17 08:00:00', '55555555-5555-5555-5555-555555555555'),
    ('task0022-5555-5555-5555-555555555555', 1, 'Task 022', FALSE, 'Details for task 022.', 'Alice', '2023-11-17 09:00:00', '55555555-5555-5555-5555-555555555555'),
    ('task0023-5555-5555-5555-555555555555', 1, 'Task 023', TRUE, 'Details for task 023.', 'Alice', '2023-11-17 10:00:00', '55555555-5555-5555-5555-555555555555'),
    ('task0024-5555-5555-5555-555555555555', 1, 'Task 024', TRUE, 'Details for task 024.', 'Chris', '2023-11-17 11:00:00', '55555555-5555-5555-5555-555555555555'),
    ('task0025-5555-5555-5555-555555555555', 1, 'Task 025', FALSE, 'Details for task 025.', NULL, '2023-11-17 12:00:00', '55555555-5555-5555-5555-555555555555');