# 小结
## proj1a
* 本次写ArrayDeque花了太长的时间，本以为很简单的东西实则而要考虑的细节却很多,为此付出了大量的精力却排查问题.
  * 一方面，我最开始使用的是两条数组用来维护数据，但实际操作中添加和删除造成的数据太乱,这样做实际上是很难行的通的.
  * 当第一种方案不行时，我立刻采用第二种方案，把数组抽像成环状具体方法如下:
    * 创建一个空数组，以数组中间为起点，定义两个指针，一个head，一个tail。分别用来代表从外界来看这个Deque 的头和尾。
    * 每次`addFirst()`的时候，我都让`head--`，我允许head能为负数，问题正是出于此。当head为负数的时候，我让它从数组的另一头开台填。虽然节省了不少空间，但让代码复杂了不少。而在给数组`resize()`的时候，特殊部分要遍历才能复制到新数组而不能采用`System.arraycopy()`的方法。
* 老师给出的`sentinel`方法确实好用，在写`LinkedListDeque`时还是不得不采用它，不然为判断`Deque`是否为空时，填加第一个`item`时一个会多一个判断语句.
* 从别的地方copy过来的代码最容易出bug
* 写测试很重要。
