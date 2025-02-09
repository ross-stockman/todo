import { Todo } from '../../types/Todo.ts';

type TodoTableRowProps = {
  todo: Todo;
};

function TodoTableRow({ todo }: TodoTableRowProps) {
  return (
    <tr key={todo.id}>
      <td>{todo.id}</td>
      <td>{todo.version}</td>
      <td>{todo.title}</td>
      <td>{todo.description}</td>
    </tr>
  );
}

export default TodoTableRow;
