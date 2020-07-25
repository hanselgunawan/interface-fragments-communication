# Communicate Between Fragments & Activity With Interface Approach

## Define an Interface
To allow a Fragment to communicate up to its Activity, you can define an interface in the Fragment class and implement it within the Activity. The Fragment captures the interface implementation during its onAttach() lifecycle method and can then call the Interface methods to communicate with the Activity.

## Steps To Implement Interface
### Create an Interface on a Fragment
```
interface FragmentAListener {
    fun onInputASent(input: String)
}
```
### Assign it to a Variable
`private var listener: FragmentAListener? = null`
### Attach The Listener Into The Activity
```
override fun onAttach(context: Context) {
    super.onAttach(context)
    
    // if context is activity, implement FragmentAListener
    if (context is FragmentAListener) {
    
        // Subscriber
        listener = context
        
    } else {
        throw RuntimeException(context.toString()
        + " must implement FragmentAListener")
    }
}
```
### Remove Listener on onDetach()
```
override fun onDetach() {
    super.onDetach()
    listener = null
}
```
### Implement The Listeners on MainActivity
```
class MainActivity : AppCompatActivity(), FragmentA.FragmentAListener, FragmentB.FragmentBListener
```

## Source
[Communicate with other fragments](https://developer.android.com/training/basics/fragments/communicating.html#DefineInterface)
