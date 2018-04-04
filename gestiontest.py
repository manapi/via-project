class Place:
    state = col = row = None
    def __init__(self,c,r):
        self.col = c
        self.row = r

    def set(self,s):
        self.state = s

class Client:
    def reserver(self,place):
        place.set("Réservé")

if __name__ == '__main__':
    client = Client()
    p1 = Place('A',0)
    liste = [p1]
    print(liste[0].state)
    client.reserver(p1)
    print(liste[0].state)
