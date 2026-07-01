package com.discord.stores;

import android.app.Application;
import androidx.fragment.app.FragmentActivity;
import com.discord.panels.PanelState;
import com.discord.panels.PanelState$a;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.home.PanelLayout;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNavigation {
    private final BehaviorSubject<PanelState> leftPanelStateSubject;
    private final SerializedSubject<StoreNavigation$PanelAction, StoreNavigation$PanelAction> navigationPanelActionSubject;
    private final BehaviorSubject<PanelState> rightPanelStateSubject;
    private final StoreStream stream;

    public StoreNavigation(StoreStream storeStream) {
        m.checkNotNullParameter(storeStream, "stream");
        this.stream = storeStream;
        this.navigationPanelActionSubject = new SerializedSubject<>(BehaviorSubject.l0(StoreNavigation$PanelAction.NOOP));
        PanelState$a panelState$a = PanelState$a.a;
        this.leftPanelStateSubject = BehaviorSubject.l0(panelState$a);
        this.rightPanelStateSubject = BehaviorSubject.l0(panelState$a);
    }

    public static /* synthetic */ void setNavigationPanelAction$default(StoreNavigation storeNavigation, StoreNavigation$PanelAction storeNavigation$PanelAction, PanelLayout panelLayout, int i, Object obj) {
        if ((i & 2) != 0) {
            panelLayout = null;
        }
        storeNavigation.setNavigationPanelAction(storeNavigation$PanelAction, panelLayout);
    }

    public final Observable<StoreNavigation$PanelAction> getNavigationPanelAction() {
        Observable<StoreNavigation$PanelAction> observableR = ObservableExtensionsKt.computationLatest(this.navigationPanelActionSubject).r();
        m.checkNotNullExpressionValue(observableR, "navigationPanelActionSub…  .distinctUntilChanged()");
        return observableR;
    }

    @StoreThread
    public final void handleHomeTabSelected(StoreNavigation$PanelAction panelAction) {
        m.checkNotNullParameter(panelAction, "panelAction");
        setNavigationPanelAction$default(this, panelAction, null, 2, null);
    }

    public final void init(Application application) {
        m.checkNotNullParameter(application, "application");
        application.registerActivityLifecycleCallbacks(new StoreNavigation$ActivityNavigationLifecycleCallbacks(this.stream));
    }

    public final void launchNotice(String noticeName, Function1<? super FragmentActivity, Boolean> showAction) {
        m.checkNotNullParameter(noticeName, "noticeName");
        m.checkNotNullParameter(showAction, "showAction");
        StoreNotices$Notice storeNotices$Notice = new StoreNotices$Notice(noticeName, null, 0L, 0, false, null, 0L, false, 0L, new StoreNavigation$launchNotice$notice$1(noticeName, showAction), Opcodes.I2F, null);
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        storeStream$Companion.getNotices().markInAppSeen();
        storeStream$Companion.getNotices().requestToShow(storeNotices$Notice);
    }

    public final Observable<PanelState> observeLeftPanelState() {
        Observable<PanelState> observableR = this.leftPanelStateSubject.r();
        m.checkNotNullExpressionValue(observableR, "leftPanelStateSubject.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<PanelState> observeRightPanelState() {
        Observable<PanelState> observableR = this.rightPanelStateSubject.r();
        m.checkNotNullExpressionValue(observableR, "rightPanelStateSubject.distinctUntilChanged()");
        return observableR;
    }

    public final void setLeftPanelState(PanelState panelState) {
        m.checkNotNullParameter(panelState, "panelState");
        this.leftPanelStateSubject.onNext(panelState);
    }

    public final void setNavigationPanelAction(StoreNavigation$PanelAction storeNavigation$PanelAction) {
        setNavigationPanelAction$default(this, storeNavigation$PanelAction, null, 2, null);
    }

    public final void setNavigationPanelAction(StoreNavigation$PanelAction actionType, PanelLayout panelLayout) {
        m.checkNotNullParameter(actionType, "actionType");
        if (panelLayout == null) {
            this.navigationPanelActionSubject.k.onNext(actionType);
            return;
        }
        int iOrdinal = actionType.ordinal();
        if (iOrdinal == 1) {
            panelLayout.openStartPanel();
        } else if (iOrdinal == 2) {
            panelLayout.closePanels();
        }
        SerializedSubject<StoreNavigation$PanelAction, StoreNavigation$PanelAction> serializedSubject = this.navigationPanelActionSubject;
        serializedSubject.k.onNext(StoreNavigation$PanelAction.NOOP);
    }

    public final void setRightPanelState(PanelState panelState) {
        m.checkNotNullParameter(panelState, "panelState");
        this.rightPanelStateSubject.onNext(panelState);
    }
}
