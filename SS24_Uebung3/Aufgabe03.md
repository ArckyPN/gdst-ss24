# Test zur Transitionsüberdeckung

start - Iterator::new() - remaining > 0 - next() - remaining() > 0 - drop(Iterator) - finish

start - Iterator::new() - remaining > 0 - first() - remaining() > 0 - drop(Iterator) - finish

start - Iterator::new() - remaining > 0 - isDone() - remaining() > 0 - drop(Iterator) - finish

start - Iterator::new() - remaining > 0 - currentItem() - remaining() > 0 - drop(Iterator) - finish

start - Iterator::new() - remaining > 0 - next() - remaining() == 0 - drop(Iterator) - finish

start - Iterator::new() - remaining == 0 - isDone() - remaining() == 0 - drop(Iterator) - finish

start - Iterator::new() - remaining == 0 - first() - remaining() == 0 - drop(Iterator) - finish

start - Iterator::new() - remaining == 0 - first() - remaining() > 0 - drop(Iterator) - finish