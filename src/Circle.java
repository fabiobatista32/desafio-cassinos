class Circle {
  Node start = null;
  final int CLOCKWISE = 0;
  final int ANTICLOCKWISE = 1;

  Node fill(int size) {
    Node node = null;
    Node nodePrev = null;
    for (int i = 1; i <= size; ++i) {
      node = new Node(i);
      if (i == 1) {
        start = node;
      } else {
        nodePrev.next = node;
        node.prev = nodePrev;
      }
      nodePrev = node;
    }
    start.prev = node;
    node.next = start;

    return start;
  }

  int count() {
    int i;
    Node node = start;
    for (i = 1; start != node.next; ++i) {
      node = node.next;
    }

    return i;
  }

  void delete(Node selected) {
    Node nodePrev = selected.prev;
    Node nodeNext = selected.next;

    if (selected == start) {
      start = start.next;
      nodePrev.next = start;
      start.prev = selected.prev;
    } else {
      nodePrev.next = nodeNext;
      nodeNext.prev = nodePrev;
    }
  }

  Node select(Node start, int n, int direction) {
    Node node = start;
    if (direction == CLOCKWISE) {
      while (--n > 0) {
        node = node.next;
      }
    } else {
      while (--n > 0) {
        node = node.prev;
      }
    }

    return node;
  }

  Node nextPosition(Node selected1, Node selected2) {
    if (selected1.next == selected2) {
      return selected2.next;
    } else {
      return selected1.next;
    }
  }

  Node prevPosition(Node selected1, Node selected2) {
    if (selected2.prev == selected1) {
      return selected1.prev;
    } else {
      return selected2.prev;
    }
  }
}
