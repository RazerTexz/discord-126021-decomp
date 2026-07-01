package org.webrtc;

import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class CameraEnumerationAndroid$ClosestComparator<T> implements Comparator<T> {
    private CameraEnumerationAndroid$ClosestComparator() {
    }

    @Override // java.util.Comparator
    public int compare(T t, T t2) {
        return diff(t) - diff(t2);
    }

    public abstract int diff(T t);

    public /* synthetic */ CameraEnumerationAndroid$ClosestComparator(CameraEnumerationAndroid$1 cameraEnumerationAndroid$1) {
        this();
    }
}
