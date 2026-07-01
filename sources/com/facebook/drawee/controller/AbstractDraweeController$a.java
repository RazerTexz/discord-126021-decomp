package com.facebook.drawee.controller;

import b.f.e.c;
import b.f.e.d;
import com.facebook.datasource.DataSource;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes.dex */
public class AbstractDraweeController$a<T> extends d<T> {
    public final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f2887b;
    public final /* synthetic */ AbstractDraweeController c;

    public AbstractDraweeController$a(AbstractDraweeController abstractDraweeController, String str, boolean z2) {
        this.c = abstractDraweeController;
        this.a = str;
        this.f2887b = z2;
    }

    @Override // b.f.e.d
    public void onFailureImpl(DataSource<T> dataSource) {
        AbstractDraweeController abstractDraweeController = this.c;
        String str = this.a;
        Throwable thD = dataSource.d();
        Map<String, Object> map = AbstractDraweeController.a;
        abstractDraweeController.u(str, dataSource, thD, true);
    }

    @Override // b.f.e.d
    public void onNewResultImpl(DataSource<T> dataSource) {
        boolean zC = dataSource.c();
        boolean zE = dataSource.e();
        float progress = dataSource.getProgress();
        T result = dataSource.getResult();
        if (result != null) {
            AbstractDraweeController abstractDraweeController = this.c;
            String str = this.a;
            boolean z2 = this.f2887b;
            Map<String, Object> map = AbstractDraweeController.a;
            abstractDraweeController.w(str, dataSource, result, progress, zC, z2, zE);
            return;
        }
        if (zC) {
            AbstractDraweeController abstractDraweeController2 = this.c;
            String str2 = this.a;
            NullPointerException nullPointerException = new NullPointerException();
            Map<String, Object> map2 = AbstractDraweeController.a;
            abstractDraweeController2.u(str2, dataSource, nullPointerException, true);
        }
    }

    @Override // b.f.e.d, b.f.e.f
    public void onProgressUpdate(DataSource<T> dataSource) {
        c cVar = (c) dataSource;
        boolean zC = cVar.c();
        float progress = cVar.getProgress();
        AbstractDraweeController abstractDraweeController = this.c;
        String str = this.a;
        Map<String, Object> map = AbstractDraweeController.a;
        if (!abstractDraweeController.o(str, cVar)) {
            abstractDraweeController.p("ignore_old_datasource @ onProgress", null);
            cVar.close();
        } else {
            if (zC) {
                return;
            }
            abstractDraweeController.k.d(progress, false);
        }
    }
}
