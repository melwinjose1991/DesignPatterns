#%% from Github : nhatcuong/DesignPatternsGangOf4

from _models import Maze
from _models import Direction
from _models import Wall
from _models import Room
from _models import Door
from itertools import product


class MazeBuilder:
    # Abstract Builder
    def build_maze(self):
        raise NotImplementedError

    def build_room(self, room_no, referent_room_no, direction_from_referent_room):
        raise NotImplementedError

    def build_door(self, room_no1, room_no2):
        raise NotImplementedError

    def getMaze(self):
        raise NotImplementedError



class StandardMazeBuilder(MazeBuilder):
    # One of the concrete builder
    def __init__(self):
        self._current_maze = None

    def build_maze(self):
        self._current_maze = Maze()

    def build_room(self, room_no, referent_room_no, direction_from_referent_room):
        if not self._current_maze.room_dict:
            self.build_first_room(room_no)
        else:
            self.build_adjacent_room(room_no, referent_room_no, direction_from_referent_room)

    def build_first_room(self, room_no):
        room = Room(room_no)
        room.set_side(Direction.NORTH, Wall())
        room.set_side(Direction.SOUTH, Wall())
        room.set_side(Direction.EAST, Wall())
        room.set_side(Direction.WEST, Wall())
        self._current_maze.add_room(room)

    def build_adjacent_room(self,room_no, referent_room_no, direction_from_referent_room):
        room = Room(room_no)
        referent_room = self._current_maze.get_room(referent_room_no)
        adjacent_site = referent_room.get_side(direction_from_referent_room)
        room.set_side(direction_from_referent_room.opposite(), adjacent_site)
        for direction in list(Direction):
            if direction != direction_from_referent_room.opposite():
                room.set_side(direction, Wall())
        self._current_maze.add_room(room)

    @staticmethod
    def common_wall(room1, room2):
        for d1, d2 in product(list(Direction), list(Direction)):
            side_room1 = room1.get_side(d1)
            side_room2 = room2.get_side(d2)
            if side_room1 == side_room2:
                return d1
        return None

    def build_door(self, room_no1, room_no2):
        assert room_no1 != room_no2
        room1 = self._current_maze.get_room(room_no1)
        room2 = self._current_maze.get_room(room_no2)
        common_wall_direction = self.common_wall(room1, room2)
        if common_wall_direction:
            door = Door(room1, room2)
            room1.set_side(common_wall_direction, door)
            room2.set_side(common_wall_direction.opposite(), door)
        else:
            assert False, 'no common wall for rooms {} and {}'.format(room_no1, room_no2)

    def getMaze(self):
        return self._current_maze



class RoomAndDoorCountMazeBuilder(MazeBuilder):
    # One of the concrete builder
    def __init__(self):
        self._count_dict = {
            'room': 0,
            'door': 0
        }

    def build_maze(self):
        pass

    def build_room(self, room_no, referent_room_no, direction_from_referent_room):
        self._count_dict['room'] += 1

    def build_door(self, room_no1, room_no2):
        self._count_dict['door'] += 1

    def getMaze(self):
        # ??? Is this right ? Shoudn't it return Maze object ???
        return self._count_dict


class MazeGame:
    # The Director - Knows the what the product consists of.
    #   The builder knows the internal & relationships b/w components.
    def buildSimpleMaze(self, builder):
        builder.build_maze()
        
        builder.build_room(1, None, None)
        builder.build_room(2, 1, Direction.NORTH)
        builder.build_door(room_no1=1, room_no2=2)
        
    def buildComplexMaze(self, builder):
        pass



if __name__ == "__main__":
    ### Client : StanderMazeBuilder
    game = MazeGame()
    standard_builder = StandardMazeBuilder()
    
    game.buildSimpleMaze(standard_builder)
    maze = standard_builder.getMaze()
    
    # This is just to verify if the maze is build in the right way
    room1 = maze.get_room(1)
    room2 = maze.get_room(2)
    north_room1 = room1.get_side(Direction.NORTH)
    south_room2 = room2.get_side(Direction.SOUTH)
    assert isinstance(north_room1, Door)
    assert south_room2 == north_room1
    print('Standard maze object {}'.format(maze))

    
    ### Client : Building RoomAndDoorCountMazeBuilder
    game = MazeGame()
    counter_builder = RoomAndDoorCountMazeBuilder()
    
    game.buildSimpleMaze(counter_builder)
    maze = counter_builder.getMaze()
    
    # This is just to verify if the maze is build in the right way
    assert maze['room'] == 2
    assert maze['door'] == 1
    print('Count room door presentation {}'.format(maze))



#%%
