package kotterknife

import android.app.Activity
import android.app.Dialog
import android.app.DialogFragment
import android.app.Fragment
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty
import android.support.v4.app.DialogFragment as SupportDialogFragment
import android.support.v4.app.Fragment as SupportFragment

fun <V : View> View.bindView(id: Int)
        : ReadOnlyProperty<View, V> = required(id, viewFinder)
fun <V : View> Activity.bindView(id: Int)
        : ReadOnlyProperty<Activity, V> = required(id, viewFinder)
fun <V : View> Dialog.bindView(id: Int)
        : ReadOnlyProperty<Dialog, V> = required(id, viewFinder)
fun <V : View> DialogFragment.bindView(id: Int)
        : ReadOnlyProperty<DialogFragment, V> = required(id, viewFinder)
fun <V : View> SupportDialogFragment.bindView(id: Int)
        : ReadOnlyProperty<SupportDialogFragment, V> = required(id, viewFinder)
fun <V : View> Fragment.bindView(id: Int)
        : ReadOnlyProperty<Fragment, V> = required(id, viewFinder)
fun <V : View> SupportFragment.bindView(id: Int)
        : ReadOnlyProperty<SupportFragment, V> = required(id, viewFinder)
fun <V : View> ViewHolder.bindView(id: Int) : ReadOnlyProperty<ViewHolder, V> = required(id, viewFinder)

fun <V : View> View.bindOptionalView(id: Int)
        : ReadOnlyProperty<View, V?> = optional(id, viewFinder)
fun <V : View> Activity.bindOptionalView(id: Int)
        : ReadOnlyProperty<Activity, V?> = optional(id, viewFinder)
fun <V : View> Dialog.bindOptionalView(id: Int)
        : ReadOnlyProperty<Dialog, V?> = optional(id, viewFinder)
fun <V : View> DialogFragment.bindOptionalView(id: Int)
        : ReadOnlyProperty<DialogFragment, V?> = optional(id, viewFinder)
fun <V : View> SupportDialogFragment.bindOptionalView(id: Int)
        : ReadOnlyProperty<SupportDialogFragment, V?> = optional(id, viewFinder)
fun <V : View> Fragment.bindOptionalView(id: Int)
        : ReadOnlyProperty<Fragment, V?> = optional(id, viewFinder)
fun <V : View> SupportFragment.bindOptionalView(id: Int)
        : ReadOnlyProperty<SupportFragment, V?> = optional(id, viewFinder)
fun <V : View> ViewHolder.bindOptionalView(id: Int)
        : ReadOnlyProperty<ViewHolder, V?> = optional(id, viewFinder)

fun <V : View> View.bindViews(vararg ids: Int)
        : ReadOnlyProperty<View, List<V>> = required(ids, viewFinder)
fun <V : View> Activity.bindViews(vararg ids: Int)
        : ReadOnlyProperty<Activity, List<V>> = required(ids, viewFinder)
fun <V : View> Dialog.bindViews(vararg ids: Int)
        : ReadOnlyProperty<Dialog, List<V>> = required(ids, viewFinder)
fun <V : View> DialogFragment.bindViews(vararg ids: Int)
        : ReadOnlyProperty<DialogFragment, List<V>> = required(ids, viewFinder)
fun <V : View> SupportDialogFragment.bindViews(vararg ids: Int)
        : ReadOnlyProperty<SupportDialogFragment, List<V>> = required(ids, viewFinder)
fun <V : View> Fragment.bindViews(vararg ids: Int)
        : ReadOnlyProperty<Fragment, List<V>> = required(ids, viewFinder)
fun <V : View> SupportFragment.bindViews(vararg ids: Int)
        : ReadOnlyProperty<SupportFragment, List<V>> = required(ids, viewFinder)
fun <V : View> ViewHolder.bindViews(vararg ids: Int)
        : ReadOnlyProperty<ViewHolder, List<V>> = required(ids, viewFinder)

fun <V : View> View.bindOptionalViews(vararg ids: Int)
        : ReadOnlyProperty<View, List<V>> = optional(ids, viewFinder)
fun <V : View> Activity.bindOptionalViews(vararg ids: Int)
        : ReadOnlyProperty<Activity, List<V>> = optional(ids, viewFinder)
fun <V : View> Dialog.bindOptionalViews(vararg ids: Int)
        : ReadOnlyProperty<Dialog, List<V>> = optional(ids, viewFinder)
fun <V : View> DialogFragment.bindOptionalViews(vararg ids: Int)
        : ReadOnlyProperty<DialogFragment, List<V>> = optional(ids, viewFinder)
fun <V : View> SupportDialogFragment.bindOptionalViews(vararg ids: Int)
        : ReadOnlyProperty<SupportDialogFragment, List<V>> = optional(ids, viewFinder)
fun <V : View> Fragment.bindOptionalViews(vararg ids: Int)
        : ReadOnlyProperty<Fragment, List<V>> = optional(ids, viewFinder)
fun <V : View> SupportFragment.bindOptionalViews(vararg ids: Int)
        : ReadOnlyProperty<SupportFragment, List<V>> = optional(ids, viewFinder)
fun <V : View> ViewHolder.bindOptionalViews(vararg ids: Int)
        : ReadOnlyProperty<ViewHolder, List<V>> = optional(ids, viewFinder)

private val View.viewFinder: View.(Int) -> View?
    get() = { findViewById(it) }
private val Activity.viewFinder: Activity.(Int) -> View?
    get() = { findViewById(it) }
private val Dialog.viewFinder: Dialog.(Int) -> View?
    get() = { findViewById(it) }
private val DialogFragment.viewFinder: DialogFragment.(Int) -> View?
    get() = { dialog.findViewById(it) }
private val SupportDialogFragment.viewFinder: SupportDialogFragment.(Int) -> View?
    get() = { dialog.findViewById(it) }
private val Fragment.viewFinder: Fragment.(Int) -> View?
    get() = { view.findViewById(it) }
private val SupportFragment.viewFinder: SupportFragment.(Int) -> View?
    get() = { view!!.findViewById(it) }
private val ViewHolder.viewFinder: ViewHolder.(Int) -> View?
    get() = { itemView.findViewById(it) }

private fun viewNotFound(id:Int, desc: KProperty<*>): Nothing =
        throw IllegalStateException("View ID $id for '${desc.name}' not found.")

fun <T : Any> View.bindString(id: Int)
        : ReadOnlyProperty<View, T> = requiredResource(id, stringResourceFinder)
fun <T : Any> Activity.bindString(id: Int)
        : ReadOnlyProperty<Activity, T> = requiredResource(id, stringResourceFinder)
fun <T : Any> Dialog.bindString(id: Int)
        : ReadOnlyProperty<Dialog, T> = requiredResource(id, stringResourceFinder)
fun <T : Any> DialogFragment.bindString(id: Int)
        : ReadOnlyProperty<DialogFragment, T> = requiredResource(id, stringResourceFinder)
fun <T : Any> SupportDialogFragment.bindString(id: Int)
        : ReadOnlyProperty<SupportDialogFragment, T> = requiredResource(id, stringResourceFinder)
fun <T : Any> Fragment.bindString(id: Int)
        : ReadOnlyProperty<Fragment, T> = requiredResource(id, stringResourceFinder)
fun <T : Any> SupportFragment.bindString(id: Int)
        : ReadOnlyProperty<SupportFragment, T> = requiredResource(id, stringResourceFinder)
fun <T : Any> ViewHolder.bindString(id: Int) : ReadOnlyProperty<ViewHolder, T> = requiredResource(id, stringResourceFinder)

private val Activity.stringResourceFinder: Activity.(Int) -> String?
    get() = { resources.getString(it) }
private val View.stringResourceFinder: View.(Int) -> String?
    get() = { resources.getString(it) }
private val Dialog.stringResourceFinder: Dialog.(Int) -> String?
    get() = { context.resources.getString(it) }
private val DialogFragment.stringResourceFinder: DialogFragment.(Int) -> String?
    get() = { resources.getString(it) }
private val Fragment.stringResourceFinder: Fragment.(Int) -> String?
    get() = { resources.getString(it) }
private val SupportFragment.stringResourceFinder: SupportFragment.(Int) -> String?
    get() = { resources.getString(it) }
private val ViewHolder.stringResourceFinder: ViewHolder.(Int) -> String?
    get() = { itemView.context.resources.getString(it) }

fun <T : Any> View.bindInteger(id: Int)
        : ReadOnlyProperty<View, T> = requiredResource(id, integerResourceFinder)
fun <T : Any> Activity.bindInteger(id: Int)
        : ReadOnlyProperty<Activity, T> = requiredResource(id, integerResourceFinder)
fun <T : Any> Dialog.bindInteger(id: Int)
        : ReadOnlyProperty<Dialog, T> = requiredResource(id, integerResourceFinder)
fun <T : Any> DialogFragment.bindInteger(id: Int)
        : ReadOnlyProperty<DialogFragment, T> = requiredResource(id, integerResourceFinder)
fun <T : Any> SupportDialogFragment.bindInteger(id: Int)
        : ReadOnlyProperty<SupportDialogFragment, T> = requiredResource(id, integerResourceFinder)
fun <T : Any> Fragment.bindInteger(id: Int)
        : ReadOnlyProperty<Fragment, T> = requiredResource(id, integerResourceFinder)
fun <T : Any> SupportFragment.bindInteger(id: Int)
        : ReadOnlyProperty<SupportFragment, T> = requiredResource(id, integerResourceFinder)
fun <T : Any> ViewHolder.bindInteger(id: Int) : ReadOnlyProperty<ViewHolder, T> = requiredResource(id, integerResourceFinder)

private val Activity.booleanResourceFinder: Activity.(Int) -> Boolean?
    get() = { resources.getBoolean(it) }
private val View.booleanResourceFinder: View.(Int) -> Boolean?
    get() = { resources.getBoolean(it) }
private val Dialog.booleanResourceFinder: Dialog.(Int) -> Boolean?
    get() = { context.resources.getBoolean(it) }
private val DialogFragment.booleanResourceFinder: DialogFragment.(Int) -> Boolean?
    get() = { resources.getBoolean(it) }
private val Fragment.booleanResourceFinder: Fragment.(Int) -> Boolean?
    get() = { resources.getBoolean(it) }
private val SupportFragment.booleanResourceFinder: SupportFragment.(Int) -> Boolean?
    get() = { resources.getBoolean(it) }
private val ViewHolder.booleanResourceFinder: ViewHolder.(Int) -> Boolean?
    get() = { itemView.context.resources.getBoolean(it) }

fun <T : Any> View.bindBoolean(id: Int)
        : ReadOnlyProperty<View, T> = requiredResource(id, booleanResourceFinder)
fun <T : Any> Activity.bindBoolean(id: Int)
        : ReadOnlyProperty<Activity, T> = requiredResource(id, booleanResourceFinder)
fun <T : Any> Dialog.bindBoolean(id: Int)
        : ReadOnlyProperty<Dialog, T> = requiredResource(id, booleanResourceFinder)
fun <T : Any> DialogFragment.bindBoolean(id: Int)
        : ReadOnlyProperty<DialogFragment, T> = requiredResource(id, booleanResourceFinder)
fun <T : Any> SupportDialogFragment.bindBoolean(id: Int)
        : ReadOnlyProperty<SupportDialogFragment, T> = requiredResource(id, booleanResourceFinder)
fun <T : Any> Fragment.bindBoolean(id: Int)
        : ReadOnlyProperty<Fragment, T> = requiredResource(id, booleanResourceFinder)
fun <T : Any> SupportFragment.bindBoolean(id: Int)
        : ReadOnlyProperty<SupportFragment, T> = requiredResource(id, booleanResourceFinder)
fun <T : Any> ViewHolder.bindBoolean(id: Int) : ReadOnlyProperty<ViewHolder, T> = requiredResource(id, booleanResourceFinder)

private val Activity.integerResourceFinder: Activity.(Int) -> Int?
    get() = { resources.getInteger(it) }
private val View.integerResourceFinder: View.(Int) -> Int?
    get() = { resources.getInteger(it) }
private val Dialog.integerResourceFinder: Dialog.(Int) -> Int?
    get() = { context.resources.getInteger(it) }
private val DialogFragment.integerResourceFinder: DialogFragment.(Int) -> Int?
    get() = { resources.getInteger(it) }
private val Fragment.integerResourceFinder: Fragment.(Int) -> Int?
    get() = { resources.getInteger(it) }
private val SupportFragment.integerResourceFinder: SupportFragment.(Int) -> Int?
    get() = { resources.getInteger(it) }
private val ViewHolder.integerResourceFinder: ViewHolder.(Int) -> Int?
    get() = { itemView.context.resources.getInteger(it) }

fun <T : Any> View.bindColor(id: Int)
        : ReadOnlyProperty<View, T> = requiredResource(id, colorResourceFinder)
fun <T : Any> Activity.bindColor(id: Int)
        : ReadOnlyProperty<Activity, T> = requiredResource(id, colorResourceFinder)
fun <T : Any> Dialog.bindColor(id: Int)
        : ReadOnlyProperty<Dialog, T> = requiredResource(id, colorResourceFinder)
fun <T : Any> DialogFragment.bindColor(id: Int)
        : ReadOnlyProperty<DialogFragment, T> = requiredResource(id, colorResourceFinder)
fun <T : Any> SupportDialogFragment.bindColor(id: Int)
        : ReadOnlyProperty<SupportDialogFragment, T> = requiredResource(id, colorResourceFinder)
fun <T : Any> Fragment.bindColor(id: Int)
        : ReadOnlyProperty<Fragment, T> = requiredResource(id, colorResourceFinder)
fun <T : Any> SupportFragment.bindColor(id: Int)
        : ReadOnlyProperty<SupportFragment, T> = requiredResource(id, colorResourceFinder)
fun <T : Any> ViewHolder.bindColor(id: Int, theme: Resources.Theme) : ReadOnlyProperty<ViewHolder, T> = requiredResource(id, colorResourceFinder)

private val Activity.colorResourceFinder: Activity.(Int) -> Int?
    get() = { ContextCompat.getColor(this, it) }
private val View.colorResourceFinder: View.(Int) -> Int?
    get() = { ContextCompat.getColor(this.context, it) }
private val Dialog.colorResourceFinder: Dialog.(Int) -> Int?
    get() = { ContextCompat.getColor(this.context, it) }
private val DialogFragment.colorResourceFinder: DialogFragment.(Int) -> Int?
    get() = { ContextCompat.getColor(this.context, it) }
private val Fragment.colorResourceFinder: Fragment.(Int) -> Int?
    get() = { ContextCompat.getColor(this.context, it) }
private val SupportFragment.colorResourceFinder: SupportFragment.(Int) -> Int?
    get() = { ContextCompat.getColor(this.context, it) }
private val ViewHolder.colorResourceFinder: ViewHolder.(Int) -> Int?
    get() = { ContextCompat.getColor(itemView.context, it) }

fun <T : Any> View.bindDrawable(id: Int)
        : ReadOnlyProperty<View, T> = requiredResource(id, drawableResourceFinder)
fun <T : Any> Activity.bindDrawable(id: Int)
        : ReadOnlyProperty<Activity, T> = requiredResource(id, drawableResourceFinder)
fun <T : Any> Dialog.bindDrawable(id: Int)
        : ReadOnlyProperty<Dialog, T> = requiredResource(id, drawableResourceFinder)
fun <T : Any> DialogFragment.bindDrawable(id: Int)
        : ReadOnlyProperty<DialogFragment, T> = requiredResource(id, drawableResourceFinder)
fun <T : Any> SupportDialogFragment.bindDrawable(id: Int)
        : ReadOnlyProperty<SupportDialogFragment, T> = requiredResource(id, drawableResourceFinder)
fun <T : Any> Fragment.bindDrawable(id: Int)
        : ReadOnlyProperty<Fragment, T> = requiredResource(id, drawableResourceFinder)
fun <T : Any> SupportFragment.bindDrawable(id: Int)
        : ReadOnlyProperty<SupportFragment, T> = requiredResource(id, drawableResourceFinder)
fun <T : Any> ViewHolder.bindDrawable(id: Int) : ReadOnlyProperty<ViewHolder, T> = requiredResource(id, drawableResourceFinder)

private val Activity.drawableResourceFinder: Activity.(Int) -> Drawable?
    get() = { ContextCompat.getDrawable(this, it) }
private val View.drawableResourceFinder: View.(Int) -> Drawable?
    get() = { ContextCompat.getDrawable(this.context, it) }
private val Dialog.drawableResourceFinder: Dialog.(Int) -> Drawable?
    get() = { ContextCompat.getDrawable(this.context, it) }
private val DialogFragment.drawableResourceFinder: DialogFragment.(Int) -> Drawable?
    get() = { ContextCompat.getDrawable(this.context, it) }
private val Fragment.drawableResourceFinder: Fragment.(Int) -> Drawable?
    get() = { ContextCompat.getDrawable(this.context, it) }
private val SupportFragment.drawableResourceFinder: SupportFragment.(Int) -> Drawable?
    get() = { ContextCompat.getDrawable(this.context, it) }
private val ViewHolder.drawableResourceFinder: ViewHolder.(Int) -> Drawable?
    get() = {ContextCompat.getDrawable(itemView.context, it) }

fun <T : Any> View.bindDimension(id: Int)
        : ReadOnlyProperty<View, T> = requiredResource(id, dimensionResourceFinder)
fun <T : Any> Activity.bindDimension(id: Int)
        : ReadOnlyProperty<Activity, T> = requiredResource(id, dimensionResourceFinder)
fun <T : Any> Dialog.bindDimension(id: Int)
        : ReadOnlyProperty<Dialog, T> = requiredResource(id, dimensionResourceFinder)
fun <T : Any> DialogFragment.bindDimension(id: Int)
        : ReadOnlyProperty<DialogFragment, T> = requiredResource(id, dimensionResourceFinder)
fun <T : Any> SupportDialogFragment.bindDimension(id: Int)
        : ReadOnlyProperty<SupportDialogFragment, T> = requiredResource(id, dimensionResourceFinder)
fun <T : Any> Fragment.bindDimension(id: Int)
        : ReadOnlyProperty<Fragment, T> = requiredResource(id, dimensionResourceFinder)
fun <T : Any> SupportFragment.bindDimension(id: Int)
        : ReadOnlyProperty<SupportFragment, T> = requiredResource(id, dimensionResourceFinder)
fun <T : Any> ViewHolder.bindDimension(id: Int) : ReadOnlyProperty<ViewHolder, T> = requiredResource(id, dimensionResourceFinder)

private val Activity.dimensionResourceFinder: Activity.(Int) -> Float?
    get() = { resources.getDimension(it) }
private val View.dimensionResourceFinder: View.(Int) -> Float?
    get() = { resources.getDimension(it) }
private val Dialog.dimensionResourceFinder: Dialog.(Int) -> Float?
    get() = { context.resources.getDimension(it) }
private val DialogFragment.dimensionResourceFinder: DialogFragment.(Int) -> Float?
    get() = { resources.getDimension(it) }
private val Fragment.dimensionResourceFinder: Fragment.(Int) -> Float?
    get() = { resources.getDimension(it) }
private val SupportFragment.dimensionResourceFinder: SupportFragment.(Int) -> Float?
    get() = { resources.getDimension(it) }
private val ViewHolder.dimensionResourceFinder: ViewHolder.(Int) -> Float?
    get() = { itemView.context.resources.getDimension(it) }

private fun resourceNotFound(id:Int, desc: KProperty<*>): Nothing =
        throw IllegalStateException("Resource ID $id for '${desc.name}' not found.")

@Suppress("UNCHECKED_CAST")
private fun <T, R : Any> requiredResource(id: Int, finder: T.(Int) -> Any?)
        = Lazy { t: T, desc -> t.finder(id) as R? ?: resourceNotFound(id, desc) }

@Suppress("UNCHECKED_CAST")
private fun <T, V : View> required(id: Int, finder: T.(Int) -> View?)
        = Lazy { t: T, desc -> t.finder(id) as V? ?: viewNotFound(id, desc) }

@Suppress("UNCHECKED_CAST")
private fun <T, V : View> optional(id: Int, finder: T.(Int) -> View?)
        = Lazy { t: T, desc ->  t.finder(id) as V? }

@Suppress("UNCHECKED_CAST")
private fun <T, V : View> required(ids: IntArray, finder: T.(Int) -> View?)
        = Lazy { t: T, desc -> ids.map { t.finder(it) as V? ?: viewNotFound(it, desc) } }

@Suppress("UNCHECKED_CAST")
private fun <T, V : View> optional(ids: IntArray, finder: T.(Int) -> View?)
        = Lazy { t: T, desc -> ids.map { t.finder(it) as V? }.filterNotNull() }

// Like Kotlin's lazy delegate but the initializer gets the target and metadata passed to it
private class Lazy<T, V>(private val initializer: (T, KProperty<*>) -> V) : ReadOnlyProperty<T, V> {
    private object EMPTY
    private var value: Any? = EMPTY

    override fun getValue(thisRef: T, property: KProperty<*>): V {
        if (value == EMPTY) {
            value = initializer(thisRef, property)
        }
        @Suppress("UNCHECKED_CAST")
        return value as V
    }
}