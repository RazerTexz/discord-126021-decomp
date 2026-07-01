package com.esotericsoftware.kryo.pool;

import b.d.b.a.outline;
import com.esotericsoftware.kryo.Kryo;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public interface KryoPool {

    public static class Builder {
        private final KryoFactory factory;
        private Queue<Kryo> queue = new ConcurrentLinkedQueue();
        private boolean softReferences;

        public Builder(KryoFactory kryoFactory) {
            if (kryoFactory == null) {
                throw new IllegalArgumentException("factory must not be null");
            }
            this.factory = kryoFactory;
        }

        public KryoPool build() {
            return new KryoPoolQueueImpl(this.factory, this.softReferences ? new SoftReferenceQueue(this.queue) : this.queue);
        }

        public Builder queue(Queue<Kryo> queue) {
            if (queue == null) {
                throw new IllegalArgumentException("queue must not be null");
            }
            this.queue = queue;
            return this;
        }

        public Builder softReferences() {
            this.softReferences = true;
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getName());
            sb.append("[queue.class=");
            sb.append(this.queue.getClass());
            sb.append(", softReferences=");
            return outline.O(sb, this.softReferences, "]");
        }
    }

    Kryo borrow();

    void release(Kryo kryo);

    <T> T run(KryoCallback<T> kryoCallback);
}
