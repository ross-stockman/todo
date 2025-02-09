import { Todo } from '../types/Todo'; // Import the type for better type safety

const API_BASE_URL = import.meta.env.VITE_API_BASE_URL;

export const fetchTodos = async (): Promise<Todo[]> => {
  const response = await fetch(`${API_BASE_URL}/api/todos`);

  if (!response.ok) {
    throw new Error(`Failed to fetch: ${response.statusText}`);
  }

  const data: Todo[] = await response.json();
  return data;
};
