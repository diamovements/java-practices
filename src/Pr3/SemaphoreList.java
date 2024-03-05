package Pr3;

import java.util.*;
import java.util.concurrent.Semaphore;

class SemaphoreList<T> implements List<T> {
    private final List<T> list;
    private final Semaphore semaphore;
    public SemaphoreList() {
        this.semaphore = new Semaphore(1);
        this.list = new ArrayList<>();
    }
    @Override
    public int size(){
        try {
            semaphore.acquire();
            return list.size();
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return 0;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public boolean isEmpty() {
        try {
            semaphore.acquire();
            return list.isEmpty();
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return false;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public boolean contains(Object o) {
        try {
            semaphore.acquire();
            return list.contains(o);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return false;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public Iterator<T> iterator() {
        try {
            semaphore.acquire();
            return list.iterator();
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return null;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public Object[] toArray() {
        try {
            semaphore.acquire();
            return list.toArray();
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return new Object[0];
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        try {
            semaphore.acquire();
            return list.toArray(a);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return null;
        }
        finally {
            semaphore.release();
        }
    }


    @Override
    public boolean add(T element) {
        try {
            semaphore.acquire();
            list.add(element);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        try {
            semaphore.acquire();
            return list.remove(o);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return false;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        try {
            semaphore.acquire();
            return list.containsAll(c);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return false;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        try {
            semaphore.acquire();
            return list.addAll(c);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return false;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        try {
            semaphore.acquire();
            return list.addAll(index, c);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return false;
        }
        finally {
            semaphore.release();
        }
    }


    @Override
    public boolean removeAll(Collection<?> c) {
        try {
            semaphore.acquire();
            return list.removeAll(c);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return false;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        try {
            semaphore.acquire();
            return list.retainAll(c);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return false;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public void clear() {
        try {
            semaphore.acquire();
            list.clear();
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public T get(int index) {
        try {
            semaphore.acquire();
            return list.get(index);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return null;
        } finally {
            semaphore.release();
        }
    }

    @Override
    public T set(int index, T element) {
        try {
            semaphore.acquire();
            return list.set(index, element);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return null;
        } finally {
            semaphore.release();
        }
    }

    @Override
    public void add(int index, T element) {
        try {
            semaphore.acquire();
            list.add(index, element);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }
    }

    @Override
    public T remove(int index) {
        try {
            semaphore.acquire();
            return list.remove(index);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return null;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public int indexOf(Object o) {
        try {
            semaphore.acquire();
            return list.indexOf(o);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return 0;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public int lastIndexOf(Object o) {
        try {
            semaphore.acquire();
            return list.lastIndexOf(o);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return 0;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public ListIterator<T> listIterator() {
        try {
            semaphore.acquire();
            return list.listIterator();
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return null;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        try {
            semaphore.acquire();
            return list.listIterator(index);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return null;
        }
        finally {
            semaphore.release();
        }
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        try {
            semaphore.acquire();
            return list.subList(fromIndex, toIndex);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            return null;
        }
        finally {
            semaphore.release();
        }
    }
    public void forEach(java.util.function.Consumer<? super T> action) {
        try {
            semaphore.acquire();
            list.forEach(action);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }
    }
}

class Main2 {
    public static void main(String[] args) {
        SemaphoreList<Integer> list = new SemaphoreList<>();
        Runnable writer = () -> {
            for (int i = 0; i < 10; i++) {
                list.add(i);
                System.out.println(Thread.currentThread().getName() + " wrote: " + i);
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        Runnable reader = () -> {
            for (int i = 0; i < 10; i++) {
                int k = list.get(i);
                System.out.println(Thread.currentThread().getName() + " read: " + k);
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        Thread writer1 = new Thread(writer);
        Thread writer2 = new Thread(writer);
        Thread reader1 = new Thread(reader);

        writer1.start();
        writer2.start();
        reader1.start();

        try {
            writer1.join();
            writer2.join();
            reader1.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("Result List: ");
            list.forEach(System.out::print);
        }
    }
}
