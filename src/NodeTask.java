public class NodeTask {

    //Represent a node of the singly linked list  
    class Node
    {
        int data;
        Node next;

        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }


    //Represent the head and tail of the singly linked list
    public Node head = null;
    public Node tail = null;
    public Node current = null;


    public void add_node(int data)
    {
        //Create a new node  
        Node newNode = new Node(data);

        //Checks if the list is empty  
        if (head == null)
        {
            //If list is empty, both head and tail will point to new node  
            head = newNode;
            tail = newNode;
        }
            else
            {
            //newNode will be added after tail such that tail's next will point to newNode  
            tail.next = newNode;
            //newNode will become new tail of the list  
            tail = newNode;
            }

    }

    public void insert_node(int data, int index)
    {

        Node newNode = new Node(data);

        if (index < 1)
        {
            throw new IllegalArgumentException("Invalid index = " + index);
        }
            if (index == 0)
            {
            newNode.next = head;
            head = newNode;
            return;
            }
        current = head;

        for (int i = 0; i < index - 1; i++)
        {

            current = current.next;
             if (current == null)
             {
                throw new IllegalArgumentException("index " + index + " is greater than the number of nodes");
             }

        }
        newNode.next = current.next;
        current.next = newNode;


    }

    public void delete_node(int index)
    {

        if (index == 0)
        {
            head = head.next;
        }
            else
           {
            Node previous = head;
            int count = 1;
            while (count < index) {

                previous = previous.next;
                count++;
                                 }
            Node current = previous.next;
            previous.next = current.next;


           }

    }

    public void get_node(int index)
    {

        Node rnd = head;
        if (index == 0)
        {
            System.out.println("indexing should start at 1");
            return;
        }

        for (int i = 0; i < index - 1; i++)
        {
            rnd = rnd.next;

        }
        System.out.println(rnd.data);
    }

    public void get_length()
    {

        int i = 0;
        Node current = head;

        while (current != null)
        {
            i++;
            current = current.next;

        }
        System.out.println("Length: " + i);
    }

    //display() will display all the nodes present in the list  
    public void display()
    {
        //Node current will point to head  
        Node current = head;
        if (head == null)
        {
            System.out.println("List is empty");
            return;
        }
        while (current != null)
        {
            //Prints each node by incrementing pointer  
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }


    public static void main(String[] args)
    {

        NodeTask ll = new NodeTask();

        ll.get_length();
        ll.add_node(10);
        ll.get_length();
        ll.add_node(20);
        ll.get_length();
        ll.add_node(30);
        ll.insert_node(15, 1);
        ll.delete_node(2);
        ll.get_node(3);
        ll.display();
        ll.get_length();


    }
}  