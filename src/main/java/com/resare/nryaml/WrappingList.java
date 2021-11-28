package com.resare.nryaml;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

class WrappingList<T> implements List<T> {

    private List<T> inner;

    public WrappingList(List<T> inner) {

        this.inner = inner;
    }

    @Override
    public int size() {
        return inner.size();
    }

    @Override
    public boolean isEmpty() {
        return inner.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return inner.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return inner.iterator();
    }

    @Override
    public Object[] toArray() {
        return inner.toArray();
    }

    @Override
    public <U> U[] toArray(U[] a) {
        return inner.toArray(a);
    }

    @Override
    public boolean add(T t) {
        return inner.add(t);
    }

    @Override
    public boolean remove(Object o) {
        return inner.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return inner.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return inner.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return inner.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return inner.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return inner.retainAll(c);
    }

    @Override
    public void clear() {
        inner.clear();
    }

    @Override
    public T get(int index) {
        return inner.get(index);
    }

    @Override
    public T set(int index, T element) {
        return inner.set(index, element);
    }

    @Override
    public void add(int index, T element) {
        inner.add(index, element);
    }

    @Override
    public T remove(int index) {
        return inner.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return inner.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return inner.lastIndexOf(o);
    }

    @Override
    public ListIterator<T> listIterator() {
        return inner.listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return inner.listIterator(index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return inner.subList(fromIndex, toIndex);
    }
}
