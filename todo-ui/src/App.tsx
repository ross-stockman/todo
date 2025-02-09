import { useEffect, useState } from 'react';
import { Todo } from './types/Todo';
import { fetchTodos } from './api/todoApi';
import './App.css';
import TodoTable from './components/TodoTable/TodoTable.tsx';
import { Modal } from './components/Modal/Modal.tsx';
import Button from './components/Button.tsx';

function App() {
  const [todos, setTodos] = useState<Todo[]>([]);
  const [error, setError] = useState<string | null>('test');
  const [isModalOpen, setIsModalOpen] = useState(true);

  const handleError = (errorMessage: string) => {
    setError(errorMessage);
    setIsModalOpen(true); // Open the modal
  };

  const handleCloseModal = () => {
    setIsModalOpen(false); // Close the modal
    setError(null); // Reset error if needed
  };

  useEffect(() => {
    const loadTodos = async () => {
      try {
        const data = await fetchTodos(); // Use the shared function
        setTodos(data); // Update state with the fetched todos
      } catch (err: any) {
        handleError(err.message || 'An unexpected error occurred');
      }
    };

    loadTodos();
  }, []);

  return (
    <div className="app-container">
      <Button onClick={() => {}}>Sample</Button>
      <TodoTable todos={todos} />
      <h1>ToDo List</h1>
      <p>
        Lorem ipsum odor amet, consectetuer adipiscing elit. Venenatis himenaeos
        maximus ultrices interdum sociosqu. Facilisi non curabitur in volutpat
        laoreet lobortis facilisis et vehicula. Sem pharetra ex varius nisi
        lectus dignissim. Vel vitae velit per sit vitae ut condimentum lectus.
        Nunc eleifend diam id maximus turpis integer adipiscing venenatis.
        Phasellus ridiculus pharetra fames himenaeos nisl litora elementum.
      </p>
      <p>
        Euismod tempor tellus etiam proin auctor class a nisi. Aliquet volutpat
        aptent praesent senectus vestibulum quam habitant egestas gravida.
        Parturient eget porta natoque; vestibulum iaculis platea in magna. Nibh
        gravida maecenas ultricies molestie finibus conubia. Arcu orci gravida
        sed sociosqu felis. Leo iaculis porttitor hac mollis magnis lobortis
        volutpat nullam. Condimentum scelerisque augue tortor faucibus efficitur
        est penatibus. Venenatis neque non purus lacus nec semper, lectus
        magnis.
      </p>
      <p>
        Pellentesque mus consequat at consequat conubia ultricies consectetur
        congue. Duis feugiat ipsum parturient parturient posuere sociosqu arcu
        tempus. Maximus lacus dapibus varius interdum; fames id varius hac.
        Interdum semper purus id consectetur torquent aliquam efficitur. Lorem
        praesent ut suspendisse litora lectus mattis purus proin. Fusce quisque
        aliquet montes maximus et purus vivamus inceptos elementum. Montes
        facilisis pellentesque risus metus suscipit suspendisse mauris dapibus.
      </p>
      <h2>ToDo List</h2>
      <p>
        Malesuada egestas malesuada ultrices felis mollis lacinia tristique.
        Ante nostra diam feugiat netus mauris; orci dapibus praesent. Maecenas
        nam adipiscing est eleifend placerat. Integer duis viverra elementum
        cursus cursus mattis elementum rutrum netus. Velit commodo eu orci curae
        facilisis lacus platea ex. Est faucibus laoreet; ante natoque curae
        metus amet. Lectus eros amet hendrerit quam mauris arcu. Pulvinar
        hendrerit mollis nec potenti suscipit elementum ex eu.
      </p>
      <h3>ToDo List</h3>
      <p>
        Ridiculus auctor inceptos erat vehicula natoque iaculis sodales. Nunc
        maximus nulla vel magna viverra metus. Id rhoncus hendrerit ridiculus
        mauris ex tristique dolor urna nascetur. Lectus metus netus fames
        egestas dapibus magnis. Class fames auctor sollicitudin ante massa
        commodo. Molestie cursus luctus viverra; in ridiculus etiam vitae.
        Ultrices phasellus cursus nec platea magna ornare facilisis. Nullam
        tortor placerat porta augue leo lobortis.
      </p>
      {isModalOpen && error && (
        <Modal title="error" message={error} onClose={handleCloseModal} />
      )}
    </div>
  );
}

export default App;
