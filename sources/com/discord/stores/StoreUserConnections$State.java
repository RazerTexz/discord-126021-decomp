package com.discord.stores;

import com.discord.api.connectedaccounts.ConnectedAccount;
import d0.z.d.g;
import d0.z.d.g0.a;
import d0.z.d.m;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreUserConnections.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class StoreUserConnections$State implements List<ConnectedAccount>, a {
    private final List<ConnectedAccount> connectedAccounts;

    private StoreUserConnections$State(List<ConnectedAccount> list) {
        this.connectedAccounts = list;
    }

    /* JADX INFO: renamed from: add, reason: avoid collision after fix types in other method */
    public void add2(int i, ConnectedAccount connectedAccount) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* synthetic */ void add(int i, ConnectedAccount connectedAccount) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean add(ConnectedAccount connectedAccount) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends ConnectedAccount> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends ConnectedAccount> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean contains(ConnectedAccount element) {
        m.checkNotNullParameter(element, "element");
        return this.connectedAccounts.contains(element);
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ConnectedAccount) {
            return contains((ConnectedAccount) obj);
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        m.checkNotNullParameter(elements, "elements");
        return this.connectedAccounts.containsAll(elements);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.List
    public ConnectedAccount get(int index) {
        ConnectedAccount connectedAccount = this.connectedAccounts.get(index);
        m.checkNotNullExpressionValue(connectedAccount, "get(...)");
        return connectedAccount;
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ ConnectedAccount get(int i) {
        return get(i);
    }

    public List<ConnectedAccount> getConnectedAccounts() {
        return this.connectedAccounts;
    }

    public int getSize() {
        return this.connectedAccounts.size();
    }

    public int indexOf(ConnectedAccount element) {
        m.checkNotNullParameter(element, "element");
        return this.connectedAccounts.indexOf(element);
    }

    @Override // java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ConnectedAccount) {
            return indexOf((ConnectedAccount) obj);
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.connectedAccounts.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<ConnectedAccount> iterator() {
        return this.connectedAccounts.iterator();
    }

    public int lastIndexOf(ConnectedAccount element) {
        m.checkNotNullParameter(element, "element");
        return this.connectedAccounts.lastIndexOf(element);
    }

    @Override // java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ConnectedAccount) {
            return lastIndexOf((ConnectedAccount) obj);
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<ConnectedAccount> listIterator() {
        return this.connectedAccounts.listIterator();
    }

    @Override // java.util.List
    public ListIterator<ConnectedAccount> listIterator(int index) {
        return this.connectedAccounts.listIterator(index);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.List
    public ConnectedAccount remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* synthetic */ ConnectedAccount remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator<ConnectedAccount> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public ConnectedAccount set2(int i, ConnectedAccount connectedAccount) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* synthetic */ ConnectedAccount set(int i, ConnectedAccount connectedAccount) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List
    public void sort(Comparator<? super ConnectedAccount> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<ConnectedAccount> subList(int fromIndex, int toIndex) {
        return this.connectedAccounts.subList(fromIndex, toIndex);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return g.toArray(this);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) g.toArray(this, tArr);
    }

    public /* synthetic */ StoreUserConnections$State(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(list);
    }
}
