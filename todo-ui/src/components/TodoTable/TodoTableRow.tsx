import { Todo } from '../../types/Todo.ts';
import styles from './TodoTable.module.css';

type TodoTableRowProps = {
  todo: Todo;
};

function TodoTableRow({ todo }: TodoTableRowProps) {
  return (
    <tr className={styles.tr} key={todo.id}>
      <td className={styles.td}>{todo.id}</td>
      <td className={styles.td} style={{ textAlign: 'center' }}>
        {todo.version}
      </td>
      <td className={styles.td}>{todo.title}</td>
      <td className={styles.td}>{todo.description}</td>
    </tr>
  );
}

export default TodoTableRow;
