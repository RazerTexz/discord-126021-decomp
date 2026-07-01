package b.a.a.f.a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.a.f.a.AudioOutputSelectionDialogViewModel2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.i.AudioOutputSelectionDialogBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.radiobutton.MaterialRadioButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import defpackage.k;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: renamed from: b.a.a.f.a.a, reason: use source file name */
/* JADX INFO: compiled from: AudioOutputSelectionDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AudioOutputSelectionDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(AudioOutputSelectionDialog.class, "binding", "getBinding()Lcom/discord/databinding/AudioOutputSelectionDialogBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final Lazy viewModel;

    /* JADX INFO: renamed from: b.a.a.f.a.a$a */
    /* JADX INFO: compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;

        public a(int i, Object obj) {
            this.j = i;
            this.k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.j;
            if (i == 0) {
                AudioOutputSelectionDialog.h((AudioOutputSelectionDialog) this.k).j.selectOutputDevice(DiscordAudioManager.DeviceTypes.BLUETOOTH_HEADSET);
                AudioOutputSelectionDialog.g((AudioOutputSelectionDialog) this.k);
                return;
            }
            if (i == 1) {
                AudioOutputSelectionDialog.h((AudioOutputSelectionDialog) this.k).j.selectOutputDevice(DiscordAudioManager.DeviceTypes.SPEAKERPHONE);
                AudioOutputSelectionDialog.g((AudioOutputSelectionDialog) this.k);
            } else if (i == 2) {
                AudioOutputSelectionDialog.h((AudioOutputSelectionDialog) this.k).j.selectOutputDevice(DiscordAudioManager.DeviceTypes.WIRED_HEADSET);
                AudioOutputSelectionDialog.g((AudioOutputSelectionDialog) this.k);
            } else {
                if (i != 3) {
                    throw null;
                }
                AudioOutputSelectionDialog.h((AudioOutputSelectionDialog) this.k).j.selectOutputDevice(DiscordAudioManager.DeviceTypes.EARPIECE);
                AudioOutputSelectionDialog.g((AudioOutputSelectionDialog) this.k);
            }
        }
    }

    /* JADX INFO: renamed from: b.a.a.f.a.a$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: AudioOutputSelectionDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.a.f.a.a$c */
    /* JADX INFO: compiled from: AudioOutputSelectionDialog.kt */
    public static final /* synthetic */ class c extends FunctionReferenceImpl implements Function1<View, AudioOutputSelectionDialogBinding> {
        public static final c j = new c();

        public c() {
            super(1, AudioOutputSelectionDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/AudioOutputSelectionDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public AudioOutputSelectionDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.audio_output_selection_bluetooth_radio;
            MaterialRadioButton materialRadioButton = (MaterialRadioButton) view2.findViewById(R.id.audio_output_selection_bluetooth_radio);
            if (materialRadioButton != null) {
                i = R.id.audio_output_selection_dialog_header;
                TextView textView = (TextView) view2.findViewById(R.id.audio_output_selection_dialog_header);
                if (textView != null) {
                    i = R.id.audio_output_selection_dialog_radio_group;
                    RadioGroup radioGroup = (RadioGroup) view2.findViewById(R.id.audio_output_selection_dialog_radio_group);
                    if (radioGroup != null) {
                        i = R.id.audio_output_selection_earpiece_radio;
                        MaterialRadioButton materialRadioButton2 = (MaterialRadioButton) view2.findViewById(R.id.audio_output_selection_earpiece_radio);
                        if (materialRadioButton2 != null) {
                            i = R.id.audio_output_selection_speaker_radio;
                            MaterialRadioButton materialRadioButton3 = (MaterialRadioButton) view2.findViewById(R.id.audio_output_selection_speaker_radio);
                            if (materialRadioButton3 != null) {
                                i = R.id.audio_output_selection_wired_radio;
                                MaterialRadioButton materialRadioButton4 = (MaterialRadioButton) view2.findViewById(R.id.audio_output_selection_wired_radio);
                                if (materialRadioButton4 != null) {
                                    return new AudioOutputSelectionDialogBinding((LinearLayout) view2, materialRadioButton, textView, radioGroup, materialRadioButton2, materialRadioButton3, materialRadioButton4);
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* JADX INFO: renamed from: b.a.a.f.a.a$d */
    /* JADX INFO: compiled from: AudioOutputSelectionDialog.kt */
    public static final class d extends Lambda implements Function1<AudioOutputSelectionDialogViewModel2.a, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(AudioOutputSelectionDialogViewModel2.a aVar) {
            int id2;
            AudioOutputSelectionDialogViewModel2.a aVar2 = aVar;
            Intrinsics3.checkNotNullParameter(aVar2, "viewState");
            AudioOutputSelectionDialog audioOutputSelectionDialog = AudioOutputSelectionDialog.this;
            Objects.requireNonNull(audioOutputSelectionDialog);
            Intrinsics3.checkNotNullParameter(aVar2, "viewState");
            if (!(aVar2 instanceof AudioOutputSelectionDialogViewModel2.a.b) && (aVar2 instanceof AudioOutputSelectionDialogViewModel2.a.C0012a)) {
                AudioOutputSelectionDialogViewModel2.a.C0012a c0012a = (AudioOutputSelectionDialogViewModel2.a.C0012a) aVar2;
                int iOrdinal = c0012a.a.ordinal();
                if (iOrdinal == 2) {
                    MaterialRadioButton materialRadioButton = audioOutputSelectionDialog.i().e;
                    Intrinsics3.checkNotNullExpressionValue(materialRadioButton, "binding.audioOutputSelectionSpeakerRadio");
                    id2 = materialRadioButton.getId();
                } else if (iOrdinal == 3) {
                    MaterialRadioButton materialRadioButton2 = audioOutputSelectionDialog.i().f;
                    Intrinsics3.checkNotNullExpressionValue(materialRadioButton2, "binding.audioOutputSelectionWiredRadio");
                    id2 = materialRadioButton2.getId();
                } else if (iOrdinal == 4) {
                    MaterialRadioButton materialRadioButton3 = audioOutputSelectionDialog.i().d;
                    Intrinsics3.checkNotNullExpressionValue(materialRadioButton3, "binding.audioOutputSelectionEarpieceRadio");
                    id2 = materialRadioButton3.getId();
                } else if (iOrdinal == 5) {
                    MaterialRadioButton materialRadioButton4 = audioOutputSelectionDialog.i().f80b;
                    Intrinsics3.checkNotNullExpressionValue(materialRadioButton4, "binding.audioOutputSelectionBluetoothRadio");
                    id2 = materialRadioButton4.getId();
                }
                audioOutputSelectionDialog.i().c.check(id2);
                MaterialRadioButton materialRadioButton5 = audioOutputSelectionDialog.i().f80b;
                Intrinsics3.checkNotNullExpressionValue(materialRadioButton5, "binding.audioOutputSelectionBluetoothRadio");
                materialRadioButton5.setVisibility(c0012a.f48b ? 0 : 8);
                MaterialRadioButton materialRadioButton6 = audioOutputSelectionDialog.i().f80b;
                Intrinsics3.checkNotNullExpressionValue(materialRadioButton6, "binding.audioOutputSelectionBluetoothRadio");
                String string = c0012a.c;
                if (string == null) {
                    string = audioOutputSelectionDialog.getString(R.string.audio_devices_bluetooth);
                }
                materialRadioButton6.setText(string);
                MaterialRadioButton materialRadioButton7 = audioOutputSelectionDialog.i().e;
                Intrinsics3.checkNotNullExpressionValue(materialRadioButton7, "binding.audioOutputSelectionSpeakerRadio");
                materialRadioButton7.setVisibility(c0012a.d ? 0 : 8);
                MaterialRadioButton materialRadioButton8 = audioOutputSelectionDialog.i().f;
                Intrinsics3.checkNotNullExpressionValue(materialRadioButton8, "binding.audioOutputSelectionWiredRadio");
                materialRadioButton8.setVisibility(c0012a.e ? 0 : 8);
                MaterialRadioButton materialRadioButton9 = audioOutputSelectionDialog.i().d;
                Intrinsics3.checkNotNullExpressionValue(materialRadioButton9, "binding.audioOutputSelectionEarpieceRadio");
                materialRadioButton9.setVisibility(c0012a.f ? 0 : 8);
            }
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.a.f.a.a$e */
    /* JADX INFO: compiled from: AudioOutputSelectionDialog.kt */
    public static final class e extends Lambda implements Function0<AudioOutputSelectionDialogViewModel2> {
        public static final e j = new e();

        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AudioOutputSelectionDialogViewModel2 invoke() {
            return new AudioOutputSelectionDialogViewModel2(null, null, 3);
        }
    }

    public AudioOutputSelectionDialog() {
        super(R.layout.audio_output_selection_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, c.j, null, 2, null);
        e eVar = e.j;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(AudioOutputSelectionDialogViewModel2.class), new k(5, appViewModelDelegates3), new AppViewModelDelegates5(eVar));
    }

    public static final void g(AudioOutputSelectionDialog audioOutputSelectionDialog) {
        Objects.requireNonNull(audioOutputSelectionDialog);
        Observable<Long> observableD0 = Observable.d0(300L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable\n        .time…S, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableD0, audioOutputSelectionDialog, null, 2, null), (Class<?>) AudioOutputSelectionDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AudioOutputSelectionDialog2(audioOutputSelectionDialog));
    }

    public static final AudioOutputSelectionDialogViewModel2 h(AudioOutputSelectionDialog audioOutputSelectionDialog) {
        return (AudioOutputSelectionDialogViewModel2) audioOutputSelectionDialog.viewModel.getValue();
    }

    public final AudioOutputSelectionDialogBinding i() {
        return (AudioOutputSelectionDialogBinding) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        int themedColor = ColorCompat.getThemedColor(view, R.attr.colorInteractiveNormal);
        MaterialRadioButton materialRadioButton = i().f80b;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton, "binding.audioOutputSelectionBluetoothRadio");
        ColorCompat2.setDrawableColor(materialRadioButton, themedColor);
        MaterialRadioButton materialRadioButton2 = i().e;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton2, "binding.audioOutputSelectionSpeakerRadio");
        ColorCompat2.setDrawableColor(materialRadioButton2, themedColor);
        MaterialRadioButton materialRadioButton3 = i().f;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton3, "binding.audioOutputSelectionWiredRadio");
        ColorCompat2.setDrawableColor(materialRadioButton3, themedColor);
        MaterialRadioButton materialRadioButton4 = i().d;
        Intrinsics3.checkNotNullExpressionValue(materialRadioButton4, "binding.audioOutputSelectionEarpieceRadio");
        ColorCompat2.setDrawableColor(materialRadioButton4, themedColor);
        i().f80b.setOnClickListener(new a(0, this));
        i().e.setOnClickListener(new a(1, this));
        i().f.setOnClickListener(new a(2, this));
        i().d.setOnClickListener(new a(3, this));
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(((AudioOutputSelectionDialogViewModel2) this.viewModel.getValue()).observeViewState(), this, null, 2, null), (Class<?>) AudioOutputSelectionDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new d());
    }
}
