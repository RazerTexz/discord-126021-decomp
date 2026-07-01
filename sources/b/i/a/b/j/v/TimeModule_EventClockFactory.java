package b.i.a.b.j.v;

import c0.a.Provider3;

/* JADX INFO: renamed from: b.i.a.b.j.v.b, reason: use source file name */
/* JADX INFO: compiled from: TimeModule_EventClockFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TimeModule_EventClockFactory implements Provider3 {

    /* JADX INFO: renamed from: b.i.a.b.j.v.b$a */
    /* JADX INFO: compiled from: TimeModule_EventClockFactory.java */
    public static final class a {
        public static final TimeModule_EventClockFactory a = new TimeModule_EventClockFactory();
    }

    @Override // c0.a.Provider3
    public Object get() {
        return new WallTimeClock();
    }
}
