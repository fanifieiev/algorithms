import logging
import timeit
from contextlib import ContextDecorator


class TimeMeter(ContextDecorator):
    def __init__(self, log: logging.Logger):
        self.star_time_ns = 0

    def __enter__(self):
        self.star_time_ns = timeit.default_timer()
        return self

    def __call__(self, func):
        self.function = func
        def inner(*args, **kwds):
            with self._recreate_cm():
                return func(*args, **kwds)

        return inner

    def __exit__(self, *exc):
        elapsed = timeit.default_timer() - self.star_time_ns
        print(f'Function: "{self.function.__name__}" took {elapsed * 1000} ms to complete.')


def timer(function):
    def execute(*args, **kwargs):
        start_time = timeit.default_timer()
        result = function(*args, **kwargs)
        elapsed = timeit.default_timer() - start_time
        print(f'Function: "{function.__name__}" took {elapsed * 1000} ms to complete.')
        print(f'Docs: "{function.__doc__}"')
        return result

    return execute
