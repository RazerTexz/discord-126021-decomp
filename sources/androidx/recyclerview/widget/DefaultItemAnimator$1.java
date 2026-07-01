package androidx.recyclerview.widget;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class DefaultItemAnimator$1 implements Runnable {
    public final /* synthetic */ DefaultItemAnimator this$0;
    public final /* synthetic */ ArrayList val$moves;

    public DefaultItemAnimator$1(DefaultItemAnimator defaultItemAnimator, ArrayList arrayList) {
        this.this$0 = defaultItemAnimator;
        this.val$moves = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (DefaultItemAnimator$MoveInfo defaultItemAnimator$MoveInfo : this.val$moves) {
            this.this$0.animateMoveImpl(defaultItemAnimator$MoveInfo.holder, defaultItemAnimator$MoveInfo.fromX, defaultItemAnimator$MoveInfo.fromY, defaultItemAnimator$MoveInfo.toX, defaultItemAnimator$MoveInfo.toY);
        }
        this.val$moves.clear();
        this.this$0.mMovesList.remove(this.val$moves);
    }
}
