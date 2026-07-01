package b.i.a.e;

import android.view.View;
import java.util.List;

/* JADX INFO: renamed from: b.i.a.e.a, reason: use source file name */
/* JADX INFO: compiled from: FlexContainer.java */
/* JADX INFO: loaded from: classes3.dex */
public interface FlexContainer {
    void a(View view, int i, int i2, FlexLine flexLine);

    void b(FlexLine flexLine);

    View c(int i);

    int d(int i, int i2, int i3);

    void e(int i, View view);

    View f(int i);

    int g(View view, int i, int i2);

    int getAlignContent();

    int getAlignItems();

    int getFlexDirection();

    int getFlexItemCount();

    List<FlexLine> getFlexLinesInternal();

    int getFlexWrap();

    int getLargestMainSize();

    int getMaxLine();

    int getPaddingBottom();

    int getPaddingEnd();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingStart();

    int getPaddingTop();

    int getSumOfCrossSize();

    int h(int i, int i2, int i3);

    boolean i();

    int j(View view);

    void setFlexLines(List<FlexLine> list);
}
