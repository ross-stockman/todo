import { Todo } from '../../types/Todo.ts';
import TodoTableRow from './TodoTableRow.tsx';

type TodoTableProps = {
  todos: Todo[];
};

function TodoTable({ todos }: TodoTableProps) {
  return (
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Version</th>
          <th>Title</th>
          <th>Description</th>
        </tr>
      </thead>
      <tbody>
        {todos.map((todo) => (
          <TodoTableRow todo={todo} />
        ))}
        {todos.length === 0 && (
          <tr>
            <td colSpan={4} style={{ textAlign: 'center' }}>
              No ToDos found.
            </td>
          </tr>
        )}
      </tbody>
    </table>
  );
}

export default TodoTable;
