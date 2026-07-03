package p507d0.p591y;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import p507d0.p580t.AbstractC12123b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.y.d */
/* JADX INFO: compiled from: FileTreeWalk.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12203d implements Sequence<File> {

    /* JADX INFO: renamed from: a */
    public final File f25253a;

    /* JADX INFO: renamed from: b */
    public final EnumC12204e f25254b;

    /* JADX INFO: renamed from: c */
    public final Function1<File, Boolean> f25255c;

    /* JADX INFO: renamed from: d */
    public final Function1<File, Unit> f25256d;

    /* JADX INFO: renamed from: e */
    public final Function2<File, IOException, Unit> f25257e;

    /* JADX INFO: renamed from: f */
    public final int f25258f;

    /* JADX INFO: renamed from: d0.y.d$a */
    /* JADX INFO: compiled from: FileTreeWalk.kt */
    public static abstract class a extends c {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(File file) {
            super(file);
            C12238m.checkNotNullParameter(file, "rootDir");
        }
    }

    /* JADX INFO: renamed from: d0.y.d$b */
    /* JADX INFO: compiled from: FileTreeWalk.kt */
    public final class b extends AbstractC12123b<File> {

        /* JADX INFO: renamed from: l */
        public final ArrayDeque<c> f25259l;

        /* JADX INFO: renamed from: d0.y.d$b$a */
        /* JADX INFO: compiled from: FileTreeWalk.kt */
        public final class a extends a {

            /* JADX INFO: renamed from: b */
            public boolean f25261b;

            /* JADX INFO: renamed from: c */
            public File[] f25262c;

            /* JADX INFO: renamed from: d */
            public int f25263d;

            /* JADX INFO: renamed from: e */
            public boolean f25264e;

            /* JADX INFO: renamed from: f */
            public final /* synthetic */ b f25265f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, File file) {
                super(file);
                C12238m.checkNotNullParameter(file, "rootDir");
                this.f25265f = bVar;
            }

            @Override // p507d0.p591y.C12203d.c
            public File step() {
                if (!this.f25264e && this.f25262c == null) {
                    Function1 function1 = C12203d.this.f25255c;
                    if (function1 != null && !((Boolean) function1.invoke(getRoot())).booleanValue()) {
                        return null;
                    }
                    File[] fileArrListFiles = getRoot().listFiles();
                    this.f25262c = fileArrListFiles;
                    if (fileArrListFiles == null) {
                        Function2 function2 = C12203d.this.f25257e;
                        if (function2 != null) {
                        }
                        this.f25264e = true;
                    }
                }
                File[] fileArr = this.f25262c;
                if (fileArr != null) {
                    int i = this.f25263d;
                    C12238m.checkNotNull(fileArr);
                    if (i < fileArr.length) {
                        File[] fileArr2 = this.f25262c;
                        C12238m.checkNotNull(fileArr2);
                        int i2 = this.f25263d;
                        this.f25263d = i2 + 1;
                        return fileArr2[i2];
                    }
                }
                if (!this.f25261b) {
                    this.f25261b = true;
                    return getRoot();
                }
                Function1 function3 = C12203d.this.f25256d;
                if (function3 != null) {
                }
                return null;
            }
        }

        /* JADX INFO: renamed from: d0.y.d$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: FileTreeWalk.kt */
        public final class C13344b extends c {

            /* JADX INFO: renamed from: b */
            public boolean f25266b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C13344b(b bVar, File file) {
                super(file);
                C12238m.checkNotNullParameter(file, "rootFile");
            }

            @Override // p507d0.p591y.C12203d.c
            public File step() {
                if (this.f25266b) {
                    return null;
                }
                this.f25266b = true;
                return getRoot();
            }
        }

        /* JADX INFO: renamed from: d0.y.d$b$c */
        /* JADX INFO: compiled from: FileTreeWalk.kt */
        public final class c extends a {

            /* JADX INFO: renamed from: b */
            public boolean f25267b;

            /* JADX INFO: renamed from: c */
            public File[] f25268c;

            /* JADX INFO: renamed from: d */
            public int f25269d;

            /* JADX INFO: renamed from: e */
            public final /* synthetic */ b f25270e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(b bVar, File file) {
                super(file);
                C12238m.checkNotNullParameter(file, "rootDir");
                this.f25270e = bVar;
            }

            /* JADX WARN: Code restructure failed: missing block: B:30:0x0085, code lost:
            
                if (r0.length == 0) goto L31;
             */
            @Override // p507d0.p591y.C12203d.c
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public File step() {
                Function2 function2;
                if (!this.f25267b) {
                    Function1 function1 = C12203d.this.f25255c;
                    if (function1 != null && !((Boolean) function1.invoke(getRoot())).booleanValue()) {
                        return null;
                    }
                    this.f25267b = true;
                    return getRoot();
                }
                File[] fileArr = this.f25268c;
                if (fileArr != null) {
                    int i = this.f25269d;
                    C12238m.checkNotNull(fileArr);
                    if (i >= fileArr.length) {
                        Function1 function3 = C12203d.this.f25256d;
                        if (function3 != null) {
                        }
                        return null;
                    }
                }
                if (this.f25268c == null) {
                    File[] fileArrListFiles = getRoot().listFiles();
                    this.f25268c = fileArrListFiles;
                    if (fileArrListFiles == null && (function2 = C12203d.this.f25257e) != null) {
                    }
                    File[] fileArr2 = this.f25268c;
                    if (fileArr2 != null) {
                        C12238m.checkNotNull(fileArr2);
                    }
                    Function1 function4 = C12203d.this.f25256d;
                    if (function4 != null) {
                    }
                    return null;
                }
                File[] fileArr3 = this.f25268c;
                C12238m.checkNotNull(fileArr3);
                int i2 = this.f25269d;
                this.f25269d = i2 + 1;
                return fileArr3[i2];
            }
        }

        public b() {
            ArrayDeque<c> arrayDeque = new ArrayDeque<>();
            this.f25259l = arrayDeque;
            if (C12203d.this.f25253a.isDirectory()) {
                arrayDeque.push(m10091c(C12203d.this.f25253a));
            } else if (C12203d.this.f25253a.isFile()) {
                arrayDeque.push(new C13344b(this, C12203d.this.f25253a));
            } else {
                this.f25173j = 3;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.io.File, java.lang.Object] */
        @Override // p507d0.p580t.AbstractC12123b
        /* JADX INFO: renamed from: a */
        public void mo10059a() {
            T tStep;
            while (true) {
                c cVarPeek = this.f25259l.peek();
                if (cVarPeek == null) {
                    tStep = 0;
                    break;
                }
                tStep = cVarPeek.step();
                if (tStep == 0) {
                    this.f25259l.pop();
                } else if (C12238m.areEqual((Object) tStep, cVarPeek.getRoot()) || !tStep.isDirectory() || this.f25259l.size() >= C12203d.this.f25258f) {
                    break;
                } else {
                    this.f25259l.push(m10091c(tStep));
                }
            }
            if (tStep == 0) {
                this.f25173j = 3;
            } else {
                this.f25174k = tStep;
                this.f25173j = 1;
            }
        }

        /* JADX INFO: renamed from: c */
        public final a m10091c(File file) {
            int iOrdinal = C12203d.this.f25254b.ordinal();
            if (iOrdinal == 0) {
                return new c(this, file);
            }
            if (iOrdinal == 1) {
                return new a(this, file);
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: renamed from: d0.y.d$c */
    /* JADX INFO: compiled from: FileTreeWalk.kt */
    public static abstract class c {

        /* JADX INFO: renamed from: a */
        public final File f25271a;

        public c(File file) {
            C12238m.checkNotNullParameter(file, "root");
            this.f25271a = file;
        }

        public final File getRoot() {
            return this.f25271a;
        }

        public abstract File step();
    }

    public C12203d(File file, EnumC12204e enumC12204e) {
        C12238m.checkNotNullParameter(file, "start");
        C12238m.checkNotNullParameter(enumC12204e, "direction");
        this.f25253a = file;
        this.f25254b = enumC12204e;
        this.f25255c = null;
        this.f25256d = null;
        this.f25257e = null;
        this.f25258f = Integer.MAX_VALUE;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<File> iterator() {
        return new b();
    }
}
