import { Todo } from '../../types/Todo.ts';
import TodoTableRow from './TodoTableRow.tsx';
import styles from './TodoTable.module.css';

type TodoTableProps = {
  todos: Todo[];
};

function TodoTable({ todos }: TodoTableProps) {
  return (
    <table className={styles.table}>
      <thead>
        <tr>
          <th className={styles.th}>ID</th>
          <th className={styles.th}>Version</th>
          <th className={styles.th}>Title</th>
          <th className={styles.th}>Description</th>
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
