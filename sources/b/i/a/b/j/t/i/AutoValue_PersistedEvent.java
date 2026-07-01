package b.i.a.b.j.t.i;

import b.d.b.a.outline;
import b.i.a.b.j.EventInternal;
import b.i.a.b.j.TransportContext;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.b.j.t.i.b, reason: use source file name */
/* JADX INFO: compiled from: AutoValue_PersistedEvent.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoValue_PersistedEvent extends PersistedEvent {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TransportContext f797b;
    public final EventInternal c;

    public AutoValue_PersistedEvent(long j, TransportContext transportContext, EventInternal eventInternal) {
        this.a = j;
        Objects.requireNonNull(transportContext, "Null transportContext");
        this.f797b = transportContext;
        Objects.requireNonNull(eventInternal, "Null event");
        this.c = eventInternal;
    }

    @Override // b.i.a.b.j.t.i.PersistedEvent
    public EventInternal a() {
        return this.c;
    }

    @Override // b.i.a.b.j.t.i.PersistedEvent
    public long b() {
        return this.a;
    }

    @Override // b.i.a.b.j.t.i.PersistedEvent
    public TransportContext c() {
        return this.f797b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersistedEvent)) {
            return false;
        }
        PersistedEvent persistedEvent = (PersistedEvent) obj;
        return this.a == persistedEvent.b() && this.f797b.equals(persistedEvent.c()) && this.c.equals(persistedEvent.a());
    }

    public int hashCode() {
        long j = this.a;
        return this.c.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.f797b.hashCode()) * 1000003);
    }

    public String toString() {
        StringBuilder sbU = outline.U("PersistedEvent{id=");
        sbU.append(this.a);
        sbU.append(", transportContext=");
        sbU.append(this.f797b);
        sbU.append(", event=");
        sbU.append(this.c);
        sbU.append("}");
        return sbU.toString();
    }
}
