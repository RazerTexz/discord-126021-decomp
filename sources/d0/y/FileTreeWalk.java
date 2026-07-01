package d0.y;

import d0.t.AbstractIterator3;
import d0.z.d.Intrinsics3;
import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;

/* JADX INFO: renamed from: d0.y.d, reason: use source file name */
/* JADX INFO: compiled from: FileTreeWalk.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FileTreeWalk implements Sequence<File> {
    public final File a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FileTreeWalk2 f3588b;
    public final Function1<File, Boolean> c;
    public final Function1<File, Unit> d;
    public final Function2<File, IOException, Unit> e;
    public final int f;

    /* JADX INFO: renamed from: d0.y.d$a */
    /* JADX INFO: compiled from: FileTreeWalk.kt */
    public static abstract class a extends c {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(File file) {
            super(file);
            Intrinsics3.checkNotNullParameter(file, "rootDir");
        }
    }

    /* JADX INFO: renamed from: d0.y.d$b */
    /* JADX INFO: compiled from: FileTreeWalk.kt */
    public final class b extends AbstractIterator3<File> {
        public final ArrayDeque<c> l;

        /* JADX INFO: renamed from: d0.y.d$b$a */
        /* JADX INFO: compiled from: FileTreeWalk.kt */
        public final class a extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f3589b;
            public File[] c;
            public int d;
            public boolean e;
            public final /* synthetic */ b f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, File file) {
                super(file);
                Intrinsics3.checkNotNullParameter(file, "rootDir");
                this.f = bVar;
            }

            @Override // d0.y.FileTreeWalk.c
            public File step() {
                if (!this.e && this.c == null) {
                    Function1 function1 = FileTreeWalk.this.c;
                    if (function1 != null && !((Boolean) function1.invoke(getRoot())).booleanValue()) {
                        return null;
                    }
                    File[] fileArrListFiles = getRoot().listFiles();
                    this.c = fileArrListFiles;
                    if (fileArrListFiles == null) {
                        Function2 function2 = FileTreeWalk.this.e;
                        if (function2 != null) {
                        }
                        this.e = true;
                    }
                }
                File[] fileArr = this.c;
                if (fileArr != null) {
                    int i = this.d;
                    Intrinsics3.checkNotNull(fileArr);
                    if (i < fileArr.length) {
                        File[] fileArr2 = this.c;
                        Intrinsics3.checkNotNull(fileArr2);
                        int i2 = this.d;
                        this.d = i2 + 1;
                        return fileArr2[i2];
                    }
                }
                if (!this.f3589b) {
                    this.f3589b = true;
                    return getRoot();
                }
                Function1 function3 = FileTreeWalk.this.d;
                if (function3 != null) {
                }
                return null;
            }
        }

        /* JADX INFO: renamed from: d0.y.d$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: FileTreeWalk.kt */
        public final class C0422b extends c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f3590b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0422b(b bVar, File file) {
                super(file);
                Intrinsics3.checkNotNullParameter(file, "rootFile");
            }

            @Override // d0.y.FileTreeWalk.c
            public File step() {
                if (this.f3590b) {
                    return null;
                }
                this.f3590b = true;
                return getRoot();
            }
        }

        /* JADX INFO: renamed from: d0.y.d$b$c */
        /* JADX INFO: compiled from: FileTreeWalk.kt */
        public final class c extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public boolean f3591b;
            public File[] c;
            public int d;
            public final /* synthetic */ b e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(b bVar, File file) {
                super(file);
                Intrinsics3.checkNotNullParameter(file, "rootDir");
                this.e = bVar;
            }

            /* JADX WARN: Code restructure failed: missing block: B:30:0x0085, code lost:
            
                if (r0.length == 0) goto L31;
             */
            @Override // d0.y.FileTreeWalk.c
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public File step() {
                Function2 function2;
                if (!this.f3591b) {
                    Function1 function1 = FileTreeWalk.this.c;
                    if (function1 != null && !((Boolean) function1.invoke(getRoot())).booleanValue()) {
                        return null;
                    }
                    this.f3591b = true;
                    return getRoot();
                }
                File[] fileArr = this.c;
                if (fileArr != null) {
                    int i = this.d;
                    Intrinsics3.checkNotNull(fileArr);
                    if (i >= fileArr.length) {
                        Function1 function3 = FileTreeWalk.this.d;
                        if (function3 != null) {
                        }
                        return null;
                    }
                }
                if (this.c == null) {
                    File[] fileArrListFiles = getRoot().listFiles();
                    this.c = fileArrListFiles;
                    if (fileArrListFiles == null && (function2 = FileTreeWalk.this.e) != null) {
                    }
                    File[] fileArr2 = this.c;
                    if (fileArr2 != null) {
                        Intrinsics3.checkNotNull(fileArr2);
                    }
                    Function1 function4 = FileTreeWalk.this.d;
                    if (function4 != null) {
                    }
                    return null;
                }
                File[] fileArr3 = this.c;
                Intrinsics3.checkNotNull(fileArr3);
                int i2 = this.d;
                this.d = i2 + 1;
                return fileArr3[i2];
            }
        }

        public b() {
            ArrayDeque<c> arrayDeque = new ArrayDeque<>();
            this.l = arrayDeque;
            if (FileTreeWalk.this.a.isDirectory()) {
                arrayDeque.push(c(FileTreeWalk.this.a));
            } else if (FileTreeWalk.this.a.isFile()) {
                arrayDeque.push(new C0422b(this, FileTreeWalk.this.a));
            } else {
                this.j = 3;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v2, types: [java.io.File, java.lang.Object] */
        @Override // d0.t.AbstractIterator3
        public void a() {
            T tStep;
            while (true) {
                c cVarPeek = this.l.peek();
                if (cVarPeek == null) {
                    tStep = 0;
                    break;
                }
                tStep = cVarPeek.step();
                if (tStep == 0) {
                    this.l.pop();
                } else if (Intrinsics3.areEqual((Object) tStep, cVarPeek.getRoot()) || !tStep.isDirectory() || this.l.size() >= FileTreeWalk.this.f) {
                    break;
                } else {
                    this.l.push(c(tStep));
                }
            }
            if (tStep == 0) {
                this.j = 3;
            } else {
                this.k = tStep;
                this.j = 1;
            }
        }

        public final a c(File file) {
            int iOrdinal = FileTreeWalk.this.f3588b.ordinal();
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
        public final File a;

        public c(File file) {
            Intrinsics3.checkNotNullParameter(file, "root");
            this.a = file;
        }

        public final File getRoot() {
            return this.a;
        }

        public abstract File step();
    }

    public FileTreeWalk(File file, FileTreeWalk2 fileTreeWalk2) {
        Intrinsics3.checkNotNullParameter(file, "start");
        Intrinsics3.checkNotNullParameter(fileTreeWalk2, "direction");
        this.a = file;
        this.f3588b = fileTreeWalk2;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = Integer.MAX_VALUE;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<File> iterator() {
        return new b();
    }
}
