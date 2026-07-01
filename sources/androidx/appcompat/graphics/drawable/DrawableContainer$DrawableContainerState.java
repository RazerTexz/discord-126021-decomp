package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources$Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable$ConstantState;
import android.os.Build$VERSION;
import android.util.SparseArray;
import androidx.annotation.RequiresApi;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes.dex */
public abstract class DrawableContainer$DrawableContainerState extends Drawable$ConstantState {
    public boolean mAutoMirrored;
    public boolean mCanConstantState;
    public int mChangingConfigurations;
    public boolean mCheckedConstantSize;
    public boolean mCheckedConstantState;
    public boolean mCheckedOpacity;
    public boolean mCheckedPadding;
    public boolean mCheckedStateful;
    public int mChildrenChangingConfigurations;
    public ColorFilter mColorFilter;
    public int mConstantHeight;
    public int mConstantMinimumHeight;
    public int mConstantMinimumWidth;
    public Rect mConstantPadding;
    public boolean mConstantSize;
    public int mConstantWidth;
    public int mDensity;
    public boolean mDither;
    public SparseArray<Drawable$ConstantState> mDrawableFutures;
    public Drawable[] mDrawables;
    public int mEnterFadeDuration;
    public int mExitFadeDuration;
    public boolean mHasColorFilter;
    public boolean mHasTintList;
    public boolean mHasTintMode;
    public int mLayoutDirection;
    public boolean mMutated;
    public int mNumChildren;
    public int mOpacity;
    public final DrawableContainer mOwner;
    public Resources mSourceRes;
    public boolean mStateful;
    public ColorStateList mTintList;
    public PorterDuff$Mode mTintMode;
    public boolean mVariablePadding;

    public DrawableContainer$DrawableContainerState(DrawableContainer$DrawableContainerState drawableContainer$DrawableContainerState, DrawableContainer drawableContainer, Resources resources) {
        this.mDensity = Opcodes.IF_ICMPNE;
        this.mVariablePadding = false;
        this.mConstantSize = false;
        this.mDither = true;
        this.mEnterFadeDuration = 0;
        this.mExitFadeDuration = 0;
        this.mOwner = drawableContainer;
        this.mSourceRes = resources != null ? resources : drawableContainer$DrawableContainerState != null ? drawableContainer$DrawableContainerState.mSourceRes : null;
        int iResolveDensity = DrawableContainer.resolveDensity(resources, drawableContainer$DrawableContainerState != null ? drawableContainer$DrawableContainerState.mDensity : 0);
        this.mDensity = iResolveDensity;
        if (drawableContainer$DrawableContainerState == null) {
            this.mDrawables = new Drawable[10];
            this.mNumChildren = 0;
            return;
        }
        this.mChangingConfigurations = drawableContainer$DrawableContainerState.mChangingConfigurations;
        this.mChildrenChangingConfigurations = drawableContainer$DrawableContainerState.mChildrenChangingConfigurations;
        this.mCheckedConstantState = true;
        this.mCanConstantState = true;
        this.mVariablePadding = drawableContainer$DrawableContainerState.mVariablePadding;
        this.mConstantSize = drawableContainer$DrawableContainerState.mConstantSize;
        this.mDither = drawableContainer$DrawableContainerState.mDither;
        this.mMutated = drawableContainer$DrawableContainerState.mMutated;
        this.mLayoutDirection = drawableContainer$DrawableContainerState.mLayoutDirection;
        this.mEnterFadeDuration = drawableContainer$DrawableContainerState.mEnterFadeDuration;
        this.mExitFadeDuration = drawableContainer$DrawableContainerState.mExitFadeDuration;
        this.mAutoMirrored = drawableContainer$DrawableContainerState.mAutoMirrored;
        this.mColorFilter = drawableContainer$DrawableContainerState.mColorFilter;
        this.mHasColorFilter = drawableContainer$DrawableContainerState.mHasColorFilter;
        this.mTintList = drawableContainer$DrawableContainerState.mTintList;
        this.mTintMode = drawableContainer$DrawableContainerState.mTintMode;
        this.mHasTintList = drawableContainer$DrawableContainerState.mHasTintList;
        this.mHasTintMode = drawableContainer$DrawableContainerState.mHasTintMode;
        if (drawableContainer$DrawableContainerState.mDensity == iResolveDensity) {
            if (drawableContainer$DrawableContainerState.mCheckedPadding) {
                this.mConstantPadding = new Rect(drawableContainer$DrawableContainerState.mConstantPadding);
                this.mCheckedPadding = true;
            }
            if (drawableContainer$DrawableContainerState.mCheckedConstantSize) {
                this.mConstantWidth = drawableContainer$DrawableContainerState.mConstantWidth;
                this.mConstantHeight = drawableContainer$DrawableContainerState.mConstantHeight;
                this.mConstantMinimumWidth = drawableContainer$DrawableContainerState.mConstantMinimumWidth;
                this.mConstantMinimumHeight = drawableContainer$DrawableContainerState.mConstantMinimumHeight;
                this.mCheckedConstantSize = true;
            }
        }
        if (drawableContainer$DrawableContainerState.mCheckedOpacity) {
            this.mOpacity = drawableContainer$DrawableContainerState.mOpacity;
            this.mCheckedOpacity = true;
        }
        if (drawableContainer$DrawableContainerState.mCheckedStateful) {
            this.mStateful = drawableContainer$DrawableContainerState.mStateful;
            this.mCheckedStateful = true;
        }
        Drawable[] drawableArr = drawableContainer$DrawableContainerState.mDrawables;
        this.mDrawables = new Drawable[drawableArr.length];
        this.mNumChildren = drawableContainer$DrawableContainerState.mNumChildren;
        SparseArray<Drawable$ConstantState> sparseArray = drawableContainer$DrawableContainerState.mDrawableFutures;
        if (sparseArray != null) {
            this.mDrawableFutures = sparseArray.clone();
        } else {
            this.mDrawableFutures = new SparseArray<>(this.mNumChildren);
        }
        int i = this.mNumChildren;
        for (int i2 = 0; i2 < i; i2++) {
            if (drawableArr[i2] != null) {
                Drawable$ConstantState constantState = drawableArr[i2].getConstantState();
                if (constantState != null) {
                    this.mDrawableFutures.put(i2, constantState);
                } else {
                    this.mDrawables[i2] = drawableArr[i2];
                }
            }
        }
    }

    private void createAllFutures() {
        SparseArray<Drawable$ConstantState> sparseArray = this.mDrawableFutures;
        if (sparseArray != null) {
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                this.mDrawables[this.mDrawableFutures.keyAt(i)] = prepareDrawable(this.mDrawableFutures.valueAt(i).newDrawable(this.mSourceRes));
            }
            this.mDrawableFutures = null;
        }
    }

    private Drawable prepareDrawable(Drawable drawable) {
        if (Build$VERSION.SDK_INT >= 23) {
            drawable.setLayoutDirection(this.mLayoutDirection);
        }
        Drawable drawableMutate = drawable.mutate();
        drawableMutate.setCallback(this.mOwner);
        return drawableMutate;
    }

    public final int addChild(Drawable drawable) {
        int i = this.mNumChildren;
        if (i >= this.mDrawables.length) {
            growArray(i, i + 10);
        }
        drawable.mutate();
        drawable.setVisible(false, true);
        drawable.setCallback(this.mOwner);
        this.mDrawables[i] = drawable;
        this.mNumChildren++;
        this.mChildrenChangingConfigurations = drawable.getChangingConfigurations() | this.mChildrenChangingConfigurations;
        invalidateCache();
        this.mConstantPadding = null;
        this.mCheckedPadding = false;
        this.mCheckedConstantSize = false;
        this.mCheckedConstantState = false;
        return i;
    }

    @RequiresApi(21)
    public final void applyTheme(Resources$Theme resources$Theme) {
        if (resources$Theme != null) {
            createAllFutures();
            int i = this.mNumChildren;
            Drawable[] drawableArr = this.mDrawables;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2] != null && drawableArr[i2].canApplyTheme()) {
                    drawableArr[i2].applyTheme(resources$Theme);
                    this.mChildrenChangingConfigurations |= drawableArr[i2].getChangingConfigurations();
                }
            }
            updateDensity(resources$Theme.getResources());
        }
    }

    @Override // android.graphics.drawable.Drawable$ConstantState
    @RequiresApi(21)
    public boolean canApplyTheme() {
        int i = this.mNumChildren;
        Drawable[] drawableArr = this.mDrawables;
        for (int i2 = 0; i2 < i; i2++) {
            Drawable drawable = drawableArr[i2];
            if (drawable == null) {
                Drawable$ConstantState drawable$ConstantState = this.mDrawableFutures.get(i2);
                if (drawable$ConstantState != null && drawable$ConstantState.canApplyTheme()) {
                    return true;
                }
            } else if (drawable.canApplyTheme()) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean canConstantState() {
        if (this.mCheckedConstantState) {
            return this.mCanConstantState;
        }
        createAllFutures();
        this.mCheckedConstantState = true;
        int i = this.mNumChildren;
        Drawable[] drawableArr = this.mDrawables;
        for (int i2 = 0; i2 < i; i2++) {
            if (drawableArr[i2].getConstantState() == null) {
                this.mCanConstantState = false;
                return false;
            }
        }
        this.mCanConstantState = true;
        return true;
    }

    public final void clearMutated() {
        this.mMutated = false;
    }

    public void computeConstantSize() {
        this.mCheckedConstantSize = true;
        createAllFutures();
        int i = this.mNumChildren;
        Drawable[] drawableArr = this.mDrawables;
        this.mConstantHeight = -1;
        this.mConstantWidth = -1;
        this.mConstantMinimumHeight = 0;
        this.mConstantMinimumWidth = 0;
        for (int i2 = 0; i2 < i; i2++) {
            Drawable drawable = drawableArr[i2];
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (intrinsicWidth > this.mConstantWidth) {
                this.mConstantWidth = intrinsicWidth;
            }
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicHeight > this.mConstantHeight) {
                this.mConstantHeight = intrinsicHeight;
            }
            int minimumWidth = drawable.getMinimumWidth();
            if (minimumWidth > this.mConstantMinimumWidth) {
                this.mConstantMinimumWidth = minimumWidth;
            }
            int minimumHeight = drawable.getMinimumHeight();
            if (minimumHeight > this.mConstantMinimumHeight) {
                this.mConstantMinimumHeight = minimumHeight;
            }
        }
    }

    public final int getCapacity() {
        return this.mDrawables.length;
    }

    @Override // android.graphics.drawable.Drawable$ConstantState
    public int getChangingConfigurations() {
        return this.mChangingConfigurations | this.mChildrenChangingConfigurations;
    }

    public final Drawable getChild(int i) {
        int iIndexOfKey;
        Drawable drawable = this.mDrawables[i];
        if (drawable != null) {
            return drawable;
        }
        SparseArray<Drawable$ConstantState> sparseArray = this.mDrawableFutures;
        if (sparseArray == null || (iIndexOfKey = sparseArray.indexOfKey(i)) < 0) {
            return null;
        }
        Drawable drawablePrepareDrawable = prepareDrawable(this.mDrawableFutures.valueAt(iIndexOfKey).newDrawable(this.mSourceRes));
        this.mDrawables[i] = drawablePrepareDrawable;
        this.mDrawableFutures.removeAt(iIndexOfKey);
        if (this.mDrawableFutures.size() == 0) {
            this.mDrawableFutures = null;
        }
        return drawablePrepareDrawable;
    }

    public final int getChildCount() {
        return this.mNumChildren;
    }

    public final int getConstantHeight() {
        if (!this.mCheckedConstantSize) {
            computeConstantSize();
        }
        return this.mConstantHeight;
    }

    public final int getConstantMinimumHeight() {
        if (!this.mCheckedConstantSize) {
            computeConstantSize();
        }
        return this.mConstantMinimumHeight;
    }

    public final int getConstantMinimumWidth() {
        if (!this.mCheckedConstantSize) {
            computeConstantSize();
        }
        return this.mConstantMinimumWidth;
    }

    public final Rect getConstantPadding() {
        Rect rect = null;
        if (this.mVariablePadding) {
            return null;
        }
        Rect rect2 = this.mConstantPadding;
        if (rect2 != null || this.mCheckedPadding) {
            return rect2;
        }
        createAllFutures();
        Rect rect3 = new Rect();
        int i = this.mNumChildren;
        Drawable[] drawableArr = this.mDrawables;
        for (int i2 = 0; i2 < i; i2++) {
            if (drawableArr[i2].getPadding(rect3)) {
                if (rect == null) {
                    rect = new Rect(0, 0, 0, 0);
                }
                int i3 = rect3.left;
                if (i3 > rect.left) {
                    rect.left = i3;
                }
                int i4 = rect3.top;
                if (i4 > rect.top) {
                    rect.top = i4;
                }
                int i5 = rect3.right;
                if (i5 > rect.right) {
                    rect.right = i5;
                }
                int i6 = rect3.bottom;
                if (i6 > rect.bottom) {
                    rect.bottom = i6;
                }
            }
        }
        this.mCheckedPadding = true;
        this.mConstantPadding = rect;
        return rect;
    }

    public final int getConstantWidth() {
        if (!this.mCheckedConstantSize) {
            computeConstantSize();
        }
        return this.mConstantWidth;
    }

    public final int getEnterFadeDuration() {
        return this.mEnterFadeDuration;
    }

    public final int getExitFadeDuration() {
        return this.mExitFadeDuration;
    }

    public final int getOpacity() {
        if (this.mCheckedOpacity) {
            return this.mOpacity;
        }
        createAllFutures();
        int i = this.mNumChildren;
        Drawable[] drawableArr = this.mDrawables;
        int opacity = i > 0 ? drawableArr[0].getOpacity() : -2;
        for (int i2 = 1; i2 < i; i2++) {
            opacity = Drawable.resolveOpacity(opacity, drawableArr[i2].getOpacity());
        }
        this.mOpacity = opacity;
        this.mCheckedOpacity = true;
        return opacity;
    }

    public void growArray(int i, int i2) {
        Drawable[] drawableArr = new Drawable[i2];
        System.arraycopy(this.mDrawables, 0, drawableArr, 0, i);
        this.mDrawables = drawableArr;
    }

    public void invalidateCache() {
        this.mCheckedOpacity = false;
        this.mCheckedStateful = false;
    }

    public final boolean isConstantSize() {
        return this.mConstantSize;
    }

    public final boolean isStateful() {
        if (this.mCheckedStateful) {
            return this.mStateful;
        }
        createAllFutures();
        int i = this.mNumChildren;
        Drawable[] drawableArr = this.mDrawables;
        boolean z2 = false;
        for (int i2 = 0; i2 < i; i2++) {
            if (drawableArr[i2].isStateful()) {
                z2 = true;
                break;
            }
        }
        this.mStateful = z2;
        this.mCheckedStateful = true;
        return z2;
    }

    public void mutate() {
        int i = this.mNumChildren;
        Drawable[] drawableArr = this.mDrawables;
        for (int i2 = 0; i2 < i; i2++) {
            if (drawableArr[i2] != null) {
                drawableArr[i2].mutate();
            }
        }
        this.mMutated = true;
    }

    public final void setConstantSize(boolean z2) {
        this.mConstantSize = z2;
    }

    public final void setEnterFadeDuration(int i) {
        this.mEnterFadeDuration = i;
    }

    public final void setExitFadeDuration(int i) {
        this.mExitFadeDuration = i;
    }

    public final boolean setLayoutDirection(int i, int i2) {
        int i3 = this.mNumChildren;
        Drawable[] drawableArr = this.mDrawables;
        boolean z2 = false;
        for (int i4 = 0; i4 < i3; i4++) {
            if (drawableArr[i4] != null) {
                boolean layoutDirection = Build$VERSION.SDK_INT >= 23 ? drawableArr[i4].setLayoutDirection(i) : false;
                if (i4 == i2) {
                    z2 = layoutDirection;
                }
            }
        }
        this.mLayoutDirection = i;
        return z2;
    }

    public final void setVariablePadding(boolean z2) {
        this.mVariablePadding = z2;
    }

    public final void updateDensity(Resources resources) {
        if (resources != null) {
            this.mSourceRes = resources;
            int iResolveDensity = DrawableContainer.resolveDensity(resources, this.mDensity);
            int i = this.mDensity;
            this.mDensity = iResolveDensity;
            if (i != iResolveDensity) {
                this.mCheckedConstantSize = false;
                this.mCheckedPadding = false;
            }
        }
    }
}
